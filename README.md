# SA-Distributed-File-System
软件体系结构 Project  

蒋雨霖

## 简单介绍
项目实现了基于微服务架构的分布式文件系统，基于Spring Boot实现NameNode和DataNode两个服务,基本实现了所有的功能要求，datanode服务可弹性扩展
同时写了一个简单的用以用户交互的前端界面。

## 使用说明及演示
### 使用说明
**1.启动namenode及datanode**. 

cd namenode  
输入下图中的命令：./mvnw spring-boot:run  
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/startnamenode.png)
之后:cd datanode 执行以下命令:  
./mvnw spring-boot:run -Dserver.port=8084  
./mvnw spring-boot:run -Dserver.port=8086  
启动了两个datanode，截图如下:
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/datanode1.png)
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/datanode2.png)  

**2.修改块大小及副本个数**  
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/size.png)

### 项目效果截图
localhost:8761/file/toPage 访问页面  
(注意上传文件的大小)  
**1.界面如下:**  
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/page.png)
**2.点击选择文件，上传文件**  
上传了a.txt和b.txt
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/selectfile.png)
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/upload.png)
**3.下载文件**  
下载a.txt  

![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/download.png)
**4.删除文件**  
将b.txt删除:
![image](https://github.com/jimmy233/SA-Distributed-File-System/blob/master/image/delete.png)




