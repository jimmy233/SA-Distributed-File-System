package com.homework.namenode.controller;

import com.homework.namenode.entity.NameNode;
import com.homework.namenode.repository.NameNodeRepository;
import com.homework.namenode.service.NameNodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@Slf4j(topic = "文件管理")
@RequestMapping("/file")
public class FileController {
    @Autowired
    private NameNodeService nameNodeService;

    @Autowired
    private NameNodeRepository repository;

    @PostMapping
    public String upload(MultipartFile file,Model model) throws IOException {
        String result = nameNodeService.upload(file);
        log.info(result);
        return "redirect:file/toPage";
    }

    @GetMapping("/delete")
    public String delete(String filename,Model model) {
        nameNodeService.delete(filename);
        List<NameNode> nameNodeList = nameNodeService.getNodeList();
        model.addAttribute("nameNodeList",nameNodeList);
        return "file";
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<byte[]> download(String filename) throws UnsupportedEncodingException {
        byte[] result = nameNodeService.download(filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）获取
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(result,
                headers, HttpStatus.CREATED);
    }

    @GetMapping("/toPage")
    public String toPage(Model model) {
        List<NameNode> nameNodeList = nameNodeService.getNodeList();
        model.addAttribute("nameNodeList",nameNodeList);
        return "file";
    }

}
