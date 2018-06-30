package com.homework.datanode.repository;

import com.homework.datanode.entity.DataNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataNodeRepository extends JpaRepository<DataNode,Long> {
    DataNode findByFilename(String filename);
}
