package com.pada.learnproject.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExampleScheduler {

    public ExampleService exampleService;
    //Do not connect Scheduled and Transactional - https://stackoverflow.com/a/45356139
    @Scheduled(cron = "${com.pada.learnproject.example.change-example-enum.cron-job")
    @SchedulerLock(name = "changeExampleEntityEnum", lockAtLeastFor = "5m", lockAtMostFor = "1h")
    public void changeExampleEntityEnumScheduled() {
        log.info("Changing example enum values: Start");
        exampleService.changeEnum();
        log.info("Changing example enum values: End");
    }

}
