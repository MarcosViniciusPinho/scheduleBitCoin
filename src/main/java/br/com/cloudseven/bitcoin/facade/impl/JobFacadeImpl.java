package br.com.cloudseven.bitcoin.facade.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.facade.JobFacade;
import br.com.cloudseven.bitcoin.service.CalculateVariableService;
import br.com.cloudseven.bitcoin.service.ScheduleService;
import br.com.cloudseven.bitcoin.service.impl.CalculateVariableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marcos Pinho
 */
@Service
public class JobFacadeImpl implements JobFacade {

//    @Autowired
//    private CalculateVariableService calculateVariableService;
    private CalculateVariableService calculateVariableService = new CalculateVariableServiceImpl();

    @Autowired
    private ScheduleService scheduleService;

    private void run(String[] values) {
        Long cont = 0L;
        do {
            BitCoin bitCoin = new BitCoin();
            this.calculateVariableService.regraColuna1(values, cont, bitCoin);
            this.calculateVariableService.regraColuna2(values, bitCoin);
            this.calculateVariableService.regraColuna3(values, bitCoin);
            this.calculateVariableService.regraColuna4(values, bitCoin);
            this.calculateVariableService.regraColuna5(cont, bitCoin);
            this.calculateVariableService.regraColuna6(cont, bitCoin);
            System.out.println("Coluna1: " + bitCoin.getColuna1());
            System.out.println("Coluna2: " + bitCoin.getColuna2());
            System.out.println("Coluna3: " + bitCoin.getColuna3());
            System.out.println("Coluna4: " + bitCoin.getColuna4());
            System.out.println("Coluna5: " + bitCoin.getColuna5());
            System.out.println("Coluna6: " + bitCoin.getColuna6());
        } while(cont > values.length);
    }

    @Override
    public void start(Long segundo) {
        this.scheduleService.start(segundo);
    }

    @Override
    public void stop() {
        this.scheduleService.stop();

        String[] values = {"0.042208", "0.041873", "0.041653", "0.041988", "0.040208",
                "0.039765", "0.041439", "0.042976", "0.040208", "0.039754", "0.043754", "0.041216",
                "0.040564"};
        this.run(values);
    }

    public static void main(String[] args){
        String[] values = {"0.042208", "0.041873", "0.041653", "0.041988", "0.040208",
                "0.039765", "0.041439", "0.042976", "0.040208", "0.039754", "0.043754", "0.041216",
                "0.040564"};

        JobFacadeImpl jobFacade = new JobFacadeImpl();
        jobFacade.run(values);

    }

}