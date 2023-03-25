package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    private static final String UPLOADED_FOLDER = System.getProperty("user.dir") + "/static/";

    @PostMapping("/upload")
    public String upload(String nickName, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickName);
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getSize());
        System.out.println(photo.getContentType());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(photo);
        System.out.println(request);
//       ServletContext是一个类，用来获取当前web应用的上下文，这里我们用的是tomcat
//        HttpServletRequest实例可以获取


        String path = request.getServletContext().getRealPath("/static/");
        System.out.println(path);
        saveFile(photo, path);
        return "success";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File upDir = new File(path);
        if (!upDir.exists()) {
            upDir.mkdir();
        }
        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);

    }


}
