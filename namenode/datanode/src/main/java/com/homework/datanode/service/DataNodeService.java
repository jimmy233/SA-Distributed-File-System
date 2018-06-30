package com.homework.datanode.service;

import com.homework.datanode.entity.DataNode;

public interface DataNodeService {
    void save(DataNode dataNode);

    void delete(String filename);

    byte[] get(String filename);
}
