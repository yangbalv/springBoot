package com.springboot.live_comm.controller;

import com.springboot.live_comm.dto.DownFileReq;
import com.springboot.live_comm.entity.fileSystem.UploadFileDetail;
import com.springboot.live_comm.entity.security.User;
import com.springboot.live_comm.mappers.mybatiss1.UploadFileDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@ResponseBody
@RequestMapping("/fileSys")
@Slf4j
public class FileSystemController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    @Autowired
    private UploadFileDetailMapper uploadFileDetailMapper;

    @Value("${configuration.fileSys.basePath}")
    private String systemBasePath;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("username+" + loginUser.getUsername());
        try {
            // 判断文件是否存在
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
            }

            // 获取文件的名称和扩展名
            String fileName = file.getOriginalFilename();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            char property = System.getProperty("file.separator").charAt(0);
            log.info("property is:" + property);
            // 创建要保存的文件对象
            String format = sdf.format(new Date());
            String path = systemBasePath + '/' + "filesystem" + '/' + format + '/' + UUID.randomUUID() + '.' + extension;
            path = path.replace('/', property);
            log.info(path);
            File destFile = new File(path);

//            File realfile = new File(destFile.getAbsolutePath());
            destFile.getParentFile().mkdirs(); // 如果目录不存在，则创建目录
            log.info(destFile.getAbsolutePath());
            UploadFileDetail uploadFileDetail = new UploadFileDetail();
            uploadFileDetail.setFileId(UUID.randomUUID().toString());
            uploadFileDetail.setFileName(fileName);
            uploadFileDetail.setPath(destFile.getAbsolutePath());
            uploadFileDetail.setUserId(loginUser.getId());
            uploadFileDetailMapper.insert(uploadFileDetail);

            // 将文件保存到磁盘上
            file.transferTo(destFile);

            return ResponseEntity.status(HttpStatus.OK).body("File saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save file");
        }
    }

    @GetMapping("/listFileDetails")
    public ResponseEntity<List<UploadFileDetail>> listFileDetails(String fileName, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        Map<String, Object> params = new HashMap<>();
        params.put("userId", loginUser.getId());
        return ResponseEntity.status(HttpStatus.OK).body(uploadFileDetailMapper.selectList(params));
    }

    @GetMapping("/listAllFileDetails")
    public ResponseEntity<List<UploadFileDetail>> listAllFileDetails(String fileName, HttpSession session) {
        return ResponseEntity.status(HttpStatus.OK).body(uploadFileDetailMapper.selectAll());
    }

    @GetMapping("/downFile")
    public void downFile(DownFileReq req, HttpServletResponse response) throws Exception {
        UploadFileDetail uploadFileDetail = uploadFileDetailMapper.selectById(req.getFileId());
        downFile(response, uploadFileDetail.getFileName(), uploadFileDetail.getPath());
    }

    public void downFile(HttpServletResponse response, String str, String path) throws Exception {
        BufferedOutputStream bouts = null;
        OutputStream outs = null;
        BufferedInputStream bins = null;
        InputStream ins = null;
        try {
            ins = new FileInputStream(path);
            bins = new BufferedInputStream(ins);// 放到缓冲流里面
            outs = response.getOutputStream();// 获取文件输出IO流
            bouts = new BufferedOutputStream(outs);
            response.setContentType("application/x-download");// 设置response内容的类型
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(str, "UTF-8"));// 设置头部信息
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            // 开始向网络传输文件流
            while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                bouts.write(buffer, 0, bytesRead);
            }
            bouts.flush();

        } catch (Exception e) {
            log.error("文件下载失败，异常信息：", e);
            throw e;
        } finally {
            if (bouts != null) {
                bouts.close();
            }
            if (outs != null) {
                outs.close();
            }
            if (bins != null) {
                bins.close();
            }
            if (ins != null) {
                ins.close();
            }
        }
    }

}
