package com.homework.datanode.controller;

import com.homework.datanode.entity.DataNode;
import com.homework.datanode.service.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/data")
public class DataContoller {

    @Autowired
    DataNodeService dataNodeService;
    @PostMapping
    public void save(byte[] block,String filename) {
        DataNode dataNode = new DataNode();
        dataNode.setFilename(filename);
        dataNode.setBlock(block);
        int i = block.length;
        dataNodeService.save(dataNode);
    }

    @GetMapping("/delete")
    public String delete(String filename) {
        dataNodeService.delete(filename);
        return "删除成功";
    }

    @GetMapping
    public byte[] get(String filename) {
       byte[] block =  dataNodeService.get(filename);
       return block;
    }
}
