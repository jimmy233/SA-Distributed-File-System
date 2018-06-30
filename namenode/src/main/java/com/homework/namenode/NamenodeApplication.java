package com.homework.namenode;

import com.homework.namenode.config.BaseConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@Slf4j(topic = "NamenodeApplication.class")
@EnableEurekaServer
@SpringBootApplication
public class NamenodeApplication implements CommandLineRunner {

	@Autowired
	private BaseConfig baseConfig;
	public static void main(String[] args) {
		SpringApplication.run(NamenodeApplication.class, args);
	}

	@Override
	public void run(String... args){
		StringBuilder sb = new StringBuilder();
		sb.append("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
		sb.append("                                  启动信息如下:\n");
		sb.append("                                  应用名称：System 0f FileManager\n");
		sb.append("                                  开发人员：蒋雨霖\n");
		sb.append("                                  主要参数：存储块大小：" + baseConfig.BLOCK_SIZE+"\n");
		sb.append("                                          	副本个数：" + baseConfig.REPLICA_NUM+"\n");
		sb.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		log.info(sb.toString());
	}
}
