package com.springboot.live_comm.controller;

import com.springboot.live_comm.entity.security.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileSystemController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");


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
            File destFile = new File("filesystem/" + format + '/' + fileName);

            File realfile = new File(destFile.getAbsolutePath());
            realfile.getParentFile().mkdirs(); // 如果目录不存在，则创建目录
            System.out.println(realfile.getAbsoluteFile());

            // 将文件保存到磁盘上
            file.transferTo(realfile);

            return ResponseEntity.status(HttpStatus.OK).body("File saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save file");
        }
    }

}
