package com.homework.namenode.listen;

import com.homework.namenode.config.BaseConfig;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j(topic = "监听服务注册中心")
public class EurekaListen {


    /**
     * datanode 注册，纳入整个系统
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String dataNodeUrl = instanceInfo.getHomePageUrl();
        log.info(dataNodeUrl + "进行注册");
        if (!BaseConfig.URL_LIST.contains(dataNodeUrl))
            BaseConfig.URL_LIST.add(dataNodeUrl);
        log.info("当前文件路径存储：" +  BaseConfig.URL_LIST.toString());
    }

}
