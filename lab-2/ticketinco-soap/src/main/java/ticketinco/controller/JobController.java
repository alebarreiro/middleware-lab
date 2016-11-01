package ticketinco.controller;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.quartz.CronScheduleBuilder;


import ticketinco.util.AnulacionReservaJob;

public class JobController {
    private static boolean runningJob = false;

    static {
        try {
            JobController.startJob();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startJob() throws Exception {
        if (JobController.runningJob) {
            return;
        }

        JobKey jobKey = new JobKey("AnulacionReserva");
        TriggerKey triggerKey = new TriggerKey("AnulacionReserva");

        JobDetail job = JobBuilder.newJob(AnulacionReservaJob.class)
                .withIdentity(jobKey)
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/10 * * * * ?")
                )
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.start();

        scheduler.scheduleJob(job, trigger);

        System.out.println("RUNNING JOB");

        JobController.runningJob = true;
    }
}
