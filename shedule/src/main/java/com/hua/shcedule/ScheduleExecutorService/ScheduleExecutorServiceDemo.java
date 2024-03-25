package com.hua.shcedule.ScheduleExecutorService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ScheduleExecutorServiceDemo {


    //延迟一秒执行一个进程任务
    @SneakyThrows
    public static void schedule(){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(
                new Runnable() {

                    @SneakyThrows
                    @Override
                    public void run() {
                        log.info("run schedule @{}", LocalDateTime.now());
                    }
                },
                1000,
                TimeUnit.MILLISECONDS);
        //waiting to process (sleep to mock)
        Thread.sleep(10000);
        //stop
        executor.shutdown();
    }


    //保证了总时间段内的执行次数
    @SneakyThrows
    public static void scheduleAtFixedRate(){
        AtomicInteger count = new AtomicInteger(0);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    @SneakyThrows
                    public void run() {
                        if(count.getAndIncrement()== 2){
                            Thread.sleep(5000);//执行时间超过执行周期

                        }
                        log.info("run scheduleAtFixedRate @{}",LocalDateTime.now());
                    }
                },
                500,
                1000,
                TimeUnit.MILLISECONDS);
        //waiting to process
        Thread.sleep(10000);

        //stop
        executor.shutdown();
    }


    @SneakyThrows
    public static void scheduleWithFixedDelay(){
        AtomicInteger count = new AtomicInteger(0);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(
                new Runnable() {
                    @Override
                    @SneakyThrows
                    public void run() {
                        if(count.getAndIncrement() == 2){
                            Thread.sleep(5000);
                        }
                        log.info("run scheduleWithFixedDelay @{}",LocalDateTime.now());
                    }
                },
                500,
                1000,//上次执行完成后 、延迟多久执行
                TimeUnit.MILLISECONDS);


        //waiting to process
        Thread.sleep(10000);

        //stop
        executor.shutdown();
    }


    public static void main(String[] args) {
        schedule();
        scheduleAtFixedRate();
        scheduleWithFixedDelay();
    }
}
