package com.homework.datanode.service.impl;

import com.homework.datanode.entity.DataNode;
import com.homework.datanode.repository.DataNodeRepository;
import com.homework.datanode.service.DataNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataNodeServiceImpl implements DataNodeService {
    @Autowired
    DataNodeRepository dataNodeRepository;
    @Override
    public void save(DataNode dataNode) {
        Arrays.toString(dataNode.getBlock());
        DataNode node = dataNodeRepository.findByFilename(dataNode.getFilename());
        if(node != null) {
            dataNodeRepository.deleteById(node.getId());
        }
        dataNodeRepository.save(dataNode);
    }

    @Override
    public void delete(String filename) {
        DataNode node = dataNodeRepository.findByFilename(filename);
        dataNodeRepository.deleteById(node.getId());
    }

    @Override
    public byte[] get(String filename) {
        DataNode node = dataNodeRepository.findByFilename(filename);
        byte[] block = node.getBlock();
        int i = block.length;
        return block;
    }

}
