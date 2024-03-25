package com.hua.shcedule.SpringSchedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//启动定时任务
@EnableScheduling
@Configuration
@Slf4j
public class SpringScheduleDemo {

    /**
     * 每隔一分钟执行一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 1)
    public void runScheduleFixedRate(){
        log.info("runScheduleFixedRate:current DateTime,{}", LocalDateTime.now());

    }

    /**
     * 每个整点小时执行一次
     */
    @Scheduled(cron = "0 0 *1/ * * ?")
    public void runScheduleCron(){
        log.info("runScheduleCron: current DateTime,{}",LocalDateTime.now());
    }


    @Scheduled(cron = "*/5 * * * * ?")
    public void runScheduleFixedRateException(){
        log.info("runScheduleFixedRateException2:currentDateTime,{}",LocalDateTime.now());
        int a = 1 / 0;
    }


}
