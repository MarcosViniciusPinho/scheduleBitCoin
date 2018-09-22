package br.com.cloudseven.bitcoin.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * @author Marcos Pinho
 */
public class JobBitCoin implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("TESTE" + LocalDateTime.now());
    }
}