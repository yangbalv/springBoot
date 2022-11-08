package com.springboot.live_comm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        System.out.println(folder);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf('.'));
        try {
            uploadFile.transferTo(new File(folder, newName));
            String filePath = folder + "/n" +
                    request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
