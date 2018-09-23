package br.com.cloudseven.bitcoin.facade.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.facade.JobFacade;
import br.com.cloudseven.bitcoin.service.CalculateVariableService;
import br.com.cloudseven.bitcoin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Marcos Pinho
 */
@Service
public class JobFacadeImpl implements JobFacade {

    @Autowired
    private CalculateVariableService calculateVariableService;

    @Autowired
    private ScheduleService scheduleService;

    private void run(String[] values) {
        Long cont = 0L;
        do {
            BitCoin bitCoin = new BitCoin();
            regraColuna1(values, cont, bitCoin);
            System.out.println("Coluna1: " + bitCoin.getColuna1());
        } while(cont > values.length);
    }

    private void regraColuna1(String[] values, Long cont, BitCoin bitCoin) {
        BigDecimal soma = BigDecimal.ZERO;
        for(String value : values) {
            soma = this.calculateVariableService.aplicarRegraColuna1(cont, bitCoin, soma, value);
            cont++;
        }
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



}