# SA-Distributed-File-System
软件体系结构 Project  

151220045 蒋雨霖

## 简单介绍
项目实现了基于微服务架构的分布式文件系统，基于Spring Boot实现NameNode和DataNode两个服务,基本实现了所有的功能要求，datanode服务可弹性扩展
同时写了一个简单的用以用户交互的前端界面。

## 使用说明及演示
### 使用说明
**1.启动namenode及datanode**
cd namenode  
输入下图中的命令：./mvnw spring-boot:run  

之后:cd datanode 执行以下命令:  
./mvnw spring-boot:run -Dserver.port=8084  
./mvnw spring-boot:run -Dserver.port=8086  
启动了两个datanode，截图如下:  

### 项目效果截图
localhost:8761/file/toPage 访问页面  
(注意上传文件的大小,小小的问题:文件如果有中文上传后下载,可能会中文乱码- -)  
**1.界面如下:**  

**2.点击选择文件，上传文件**  

**3.下载文件**  

**4.删除文件**  

将b.txt删除  




