package com.dsr.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class UpOrDownFileController {
    @RequestMapping("/downFile")
    public ResponseEntity<byte[]> downFile(HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("index.jsp");
        File file=new File(realPath);
        FileInputStream in=new FileInputStream(file);
        byte[] readBytes=new byte[in.available()];
        in.read(readBytes);
        in.close();
        HttpHeaders headers=new HttpHeaders();
        headers.set("Content-Disposition","attachment;filename=index.jsp");
        ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(readBytes,headers, HttpStatus.OK);
        return responseEntity;
    }

    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        file.transferTo(new File(""));
        return "success";
    }
}
