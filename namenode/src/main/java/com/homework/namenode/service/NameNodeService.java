package com.homework.namenode.service;

import com.homework.namenode.entity.NameNode;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sunyiran
 * @date 2018-06-29
 * @purpose
 */
public interface NameNodeService {
    String upload(MultipartFile file);
    void delete(String filename);
    byte[] download(String filename);

    List<NameNode> getNodeList();
}
