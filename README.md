# SA-Distributed-File-System
软件体系结构 Project
151220045 蒋雨霖

## 简单介绍
项目实现了基于微服务架构的分布式文件系统，基于Spring Boot实现NameNode和DataNode两个服务,
同时写了一个简单的用以用户交互的前端界面。

## 使用说明及演示
**1.启动namenode及datanode**
cd namenode  
输入下图中的命令：./mvnw spring-boot:run  

之后:cd datanode 执行以下命令:  
./mvnw spring-boot:run -Dserver.port=8084  
./mvnw spring-boot:run -Dserver.port=8086  
启动了两个datanode，截图如下:  


