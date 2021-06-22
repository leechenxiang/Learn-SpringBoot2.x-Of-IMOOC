package com.imooc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@Configuration          // 1. 标记配置类，使得springboot容器可以扫描到
//@EnableScheduling       // 2. 开启定时任务
@Slf4j
public class MyTask {

    // 3. 添加一个任务，并且注明任务的运行表达式
    @Scheduled(cron = "*/5 * * * * ?")
    public void publishMsg() {
        log.warn("开始执行任务: " + LocalDateTime.now());
    }

//    常用的定时任务表达式：
//    每隔5秒执行一次：*/5 * * * * ?
//    每隔1分钟执行一次：0 */1 * * * ?
//    每天23点执行一次：0 0 23 * * ?
//    每天凌晨1点执行一次：0 0 1 * * ?
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//    每月最后一天23点执行一次：0 0 23 L * ?
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//    在26分、29分、33分执行一次：0 26,29,33 * * * ?
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

}
