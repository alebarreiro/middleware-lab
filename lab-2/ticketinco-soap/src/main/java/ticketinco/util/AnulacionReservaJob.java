package ticketinco.util;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.JobDataMap;
import ticketinco.controller.ReservaController;
import org.apache.log4j.Logger;

public class AnulacionReservaJob implements Job {
    final static Logger logger = Logger.getLogger(AnulacionReservaJob.class);

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        logger.debug("AnulacionReservaJob: call -> expirarReservas()");

        new ReservaController().expirarReservas();
    }
}
