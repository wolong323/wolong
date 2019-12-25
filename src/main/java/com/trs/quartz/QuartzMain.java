package com.trs.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author 陈曦
 */
public class QuartzMain {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail= JobBuilder.newJob(QuartzDemo.class).build();
        Trigger trigger= TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        Scheduler scheduler= StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
