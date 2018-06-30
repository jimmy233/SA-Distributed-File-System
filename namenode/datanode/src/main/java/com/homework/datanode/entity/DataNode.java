package com.homework.datanode.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class DataNode {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String filename;
    @Lob
    private byte[] block;
}
