package com.tl.statistics.scheduled;

import com.tl.statistics.service.DailyService;
import com.tl.statistics.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author tl
 * @Date 2020/9/22
 */
@Component
public class ScheduledTask {
    @Autowired
    private DailyService dailyService;


    //每5秒执行一次
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void task1() {
//        System.out.println("*********++++++++++++*****执行了");
//    }

    //每天凌晨两点执行
    @Scheduled(cron = "0 0 2 * * ? ")
    public void task2() {
        dailyService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
