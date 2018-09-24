package br.com.cloudseven.bitcoin.facade.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.facade.JobFacade;
import br.com.cloudseven.bitcoin.service.CalculateVariableService;
import br.com.cloudseven.bitcoin.service.ScheduleService;
import br.com.cloudseven.bitcoin.service.impl.CalculateVariableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    private void run(List<String> values) {
        BitCoin bitCoin = new BitCoin();
        this.calculateVariableService.regraColuna1(values, bitCoin);
        this.calculateVariableService.regraColuna2(values, bitCoin);
        this.calculateVariableService.regraColuna3(values, bitCoin);
        this.calculateVariableService.regraColuna4(values, bitCoin);
        this.calculateVariableService.regraColuna5(bitCoin);
        this.calculateVariableService.regraColuna6(bitCoin);
        this.calculateVariableService.regraColuna7(bitCoin);
        this.calculateVariableService.regraColuna8(bitCoin);
        System.out.println("Coluna1: " + bitCoin.getColuna1());
        System.out.println("Coluna2: " + bitCoin.getColuna2());
        System.out.println("Coluna3: " + bitCoin.getColuna3());
        System.out.println("Coluna4: " + bitCoin.getColuna4());
        System.out.println("Coluna5: " + bitCoin.getColuna5());
        System.out.println("Coluna6: " + bitCoin.getColuna6());
        System.out.println("Coluna7: " + bitCoin.getColuna7());
        System.out.println("Coluna8: " + bitCoin.getColuna8());
    }

    @Override
    public void start(Long segundo) {
        this.scheduleService.start(segundo);
    }

    @Override
    public void stop() {
        this.scheduleService.stop();

        List<String> values = Arrays.asList("0.042208", "0.041873", "0.041653", "0.041988", "0.040208",
                "0.039765", "0.041439", "0.042976", "0.040208", "0.039754", "0.043754", "0.041216",
                "0.040564");
        this.run(values);
    }

    public static void main(String[] args){
        List<String> values = Arrays.asList("0.042208", "0.041873", "0.041653", "0.041988", "0.040208",
                "0.039765", "0.041439", "0.042976", "0.040208", "0.039754", "0.043754", "0.041216",
                "0.040564");

        JobFacadeImpl jobFacade = new JobFacadeImpl();
        jobFacade.run(values);

    }

}