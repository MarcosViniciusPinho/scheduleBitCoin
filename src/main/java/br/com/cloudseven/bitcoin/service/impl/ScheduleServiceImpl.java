package br.com.cloudseven.bitcoin.service.impl;

import br.com.cloudseven.bitcoin.job.JobBitCoin;
import br.com.cloudseven.bitcoin.service.ScheduleService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Pinho
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void start(Long segundo) {

        String secound = String.format("0/%d * * * * ?", segundo);

        JobDetail job = JobBuilder.newJob(JobBitCoin.class).withIdentity("jobBitCoin", "group1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule(secound))
                .build();

        try {
            this.scheduler.start();
            this.scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {
        try {
            JobKey jobKey = new JobKey("jobBitCoin", "group1");
            boolean isJobExist = this.scheduler.checkExists(jobKey);
            if(isJobExist) {
                this.scheduler.deleteJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}