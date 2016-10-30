package ticketinco.util;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.JobDataMap;
import ticketinco.controller.ReservaController;

import java.util.List;
import java.util.Date;

public class AnulacionReservaJob implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        System.out.println("Anulando reservaaaas");

        new ReservaController().expirarReservas();
    }
}
