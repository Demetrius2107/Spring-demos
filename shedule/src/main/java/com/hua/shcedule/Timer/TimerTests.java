package com.hua.shcedule.Timer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class TimerTests {


    @SneakyThrows
    public static void timer(){
        //start Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @SneakyThrows
            @Override
            public void run() {
                log.info("Timer-task@{}", LocalDateTime.now());
                Thread.sleep(100);
            }
        },1000);

        //waiting to process
        Thread.sleep(10000);

        //stop timer
        timer.cancel();
    }


    @SneakyThrows
    public static void timerPeroid(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            @SneakyThrows
            public void run() {
                log.info("timer-period-task",LocalDateTime.now());
                Thread.sleep(100);
            }
        },500,1000);
        Thread.sleep(10000);
        timer.cancel();
    }
        @SneakyThrows
        public static void timerFixedRate(){
            //start timer
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int count = 0;

                @Override
                @SneakyThrows
                public void run() {
                    if (count++ == 2) {
                        Thread.sleep(5000);//第一次执行时间超过执行周期
                    }
                    log.info("timer-fixedRate-task @{}", LocalDateTime.now());
                }
            },500,100);

            Thread.sleep(10000);

            //stop timer
            timer.cancel();
        }

    public static void main(String[] args) {
        timer();
        timerPeroid();
        timerFixedRate();
    }



}
