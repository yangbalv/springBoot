package com.springboot.live_comm.controller;

import com.springboot.live_comm.entity.fileSyetem.UploadFileDetail;
import com.springboot.live_comm.entity.security.User;

import com.springboot.live_comm.mappers.mybatiss1.UploadFileDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class FileSystemController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    @Autowired
    private UploadFileDetailMapper uploadFileDetailMapper;


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

            // 创建要保存的文件对象
            String format = sdf.format(new Date());
            File destFile = new File("filesystem/" + format + '/' + UUID.randomUUID() + extension);

            File realfile = new File(destFile.getAbsolutePath());
            realfile.getParentFile().mkdirs(); // 如果目录不存在，则创建目录
            System.out.println(realfile.getAbsoluteFile());
            UploadFileDetail uploadFileDetail = new UploadFileDetail();
            uploadFileDetail.setId(UUID.randomUUID().toString());
            uploadFileDetail.setFileName(fileName);
            uploadFileDetail.setPath(destFile.getAbsolutePath());
            uploadFileDetail.setUserId(loginUser.getId());
            uploadFileDetailMapper.insert(uploadFileDetail);

            // 将文件保存到磁盘上
            file.transferTo(realfile);

            return ResponseEntity.status(HttpStatus.OK).body("File saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save file");
        }
    }

    @GetMapping("/listFileDetails")
    public ResponseEntity<List<UploadFileDetail>> listFileDetails(HttpSession session) {

        return null;

    }

}
