package com.homework.namenode.repository;

import com.homework.namenode.entity.NameNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NameNodeRepository extends JpaRepository<NameNode,Long> {
    NameNode getByFilename(String filename);

}
