package com.homework.namenode.service;

import com.homework.namenode.entity.NameNode;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface NameNodeService {
    String upload(MultipartFile file);
    void delete(String filename);
    byte[] download(String filename);

    List<NameNode> getNodeList();
}
