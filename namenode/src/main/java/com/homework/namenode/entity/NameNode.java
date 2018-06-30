package com.homework.namenode.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;


@Entity
@Data
public class NameNode {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String filename;
    private Integer fileSize;
    @Basic
    private LinkedList<String> urlList = new LinkedList<>();//记录存储路径
}
