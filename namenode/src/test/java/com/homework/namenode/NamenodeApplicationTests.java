package com.homework.namenode;

import com.homework.namenode.entity.NameNode;
import com.homework.namenode.repository.NameNodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NamenodeApplicationTests {

	@Autowired
	NameNodeRepository repository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		NameNode nameNode = new NameNode();
		nameNode.setFilename("test.doc");
		nameNode.setFileSize(10000);
		nameNode.getUrlList().add("tesst11");
		repository.save(nameNode);

	}
	@Test
	public void test1() {
		List<NameNode> all = repository.findAll();
		System.out.println(all);
	}
}
