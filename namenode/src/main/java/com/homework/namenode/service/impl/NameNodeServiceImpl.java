package com.homework.namenode.service.impl;

import com.homework.namenode.config.BaseConfig;
import com.homework.namenode.entity.NameNode;
import com.homework.namenode.repository.NameNodeRepository;
import com.homework.namenode.service.NameNodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyiran
 * @date 2018-06-29
 * @purpose
 */
@Service
@Slf4j
public class NameNodeServiceImpl implements NameNodeService {
    @Autowired
    BaseConfig baseConfig;
    @Autowired
    NameNodeRepository nameNodeRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        log.debug("开始文件上传，文件名：" + filename);
        byte[] fileBytes = null;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return "未知异常，无法上传";
        }
        if (fileBytes.length > baseConfig.BLOCK_SIZE * baseConfig.REPLICA_NUM) {
            return "文件过大，无法上传";
        }
        NameNode nameNode = new NameNode();
        nameNode.setFilename(filename);
        nameNode.setFileSize( fileBytes.length);
        int needNum = fileBytes.length % baseConfig.BLOCK_SIZE == 0 ?
                fileBytes.length / baseConfig.BLOCK_SIZE : fileBytes.length / baseConfig.BLOCK_SIZE + 1;

        for (int i = 0; i < needNum; i++) {
            log.info("上传路径：" + BaseConfig.URL_LIST.get(i)+"/data?filename=" + filename);
            nameNode.getUrlList().add(BaseConfig.URL_LIST.get(i));
            byte[] block = null;
            if(fileBytes.length < baseConfig.BLOCK_SIZE) {
              block = Arrays.copyOfRange(fileBytes, i * baseConfig.BLOCK_SIZE, i * baseConfig.BLOCK_SIZE +fileBytes.length);
            }else {
                block = Arrays.copyOfRange(fileBytes, i * baseConfig.BLOCK_SIZE, (i +1)* baseConfig.BLOCK_SIZE);
            }
            MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
            map.add("filename",filename);
            map.add("block",block);
            Arrays.toString(block);
            restTemplate.postForObject(BaseConfig.URL_LIST.get(i)+"/data",map, String.class);
        }
       // if(nameNodeRepository.getByFilename(filename) != null)
        nameNodeRepository.save(nameNode);
        return "文件上传成功";
    }

    @Override
    public void delete(String filename) {
        NameNode nameNode = nameNodeRepository.getByFilename(filename);
        LinkedList<String> list = nameNode.getUrlList();
        for (int i = 0; i < list.size() ; i++) {
            restTemplate.getForObject(list.get(i) + "/data/delete?filename=" + filename,String.class);
        }
        nameNodeRepository.deleteById(nameNode.getId());
    }

    @Override
    public byte[] download(String filename) {
        NameNode nameNode = nameNodeRepository.getByFilename(filename);
        LinkedList<String> list = nameNode.getUrlList();
        byte[] file = new byte[0];
        for (int i = 0; i < list.size() ; i++) {
            byte[] bytes = restTemplate.getForObject(list.get(i) + "/data?filename=" + filename, byte[].class);
           file = ArrayUtils.addAll(file,bytes);
        }
        return file;
    }

    @Override
    public List<NameNode> getNodeList() {
        return nameNodeRepository.findAll();
    }
}
