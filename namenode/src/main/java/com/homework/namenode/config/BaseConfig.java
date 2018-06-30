package com.homework.namenode.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class BaseConfig {

    //当前存在的服务
    public static List<String> URL_LIST = new LinkedList<>();

    // block 大小
    @Value(value = "${blockSize}")
    public int BLOCK_SIZE;

    // 副本数
    @Value(value = "${dataNum}")
    public int REPLICA_NUM;


}
