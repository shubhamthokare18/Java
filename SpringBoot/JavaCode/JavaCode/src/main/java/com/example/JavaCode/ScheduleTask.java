package com.example.JavaCode;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTask {
    int a = 0;

    @Scheduled(cron = "5 33  16 * 9 5")
    public void cleanTempFile() throws InterruptedException {
        System.out.println("hi");
        Thread.sleep(5000);
            System.out.println(a + " clean temp file at " + System.currentTimeMillis());
            a++;
        }

    }