package br.com.cloudseven.bitcoin.service.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.service.impl.util.RegraUtil;

import java.math.BigDecimal;

/**
 * @author Marcos Pinho
 */
public class CalculateVariableServiceImpl {

    public void run(String[] values) {
        Long cont = 0L;
        do {
            BitCoin bitCoin = new BitCoin();
            regraColuna1(values, cont, bitCoin);
            System.out.println(bitCoin.getColuna1());
        } while(cont > values.length);
    }

    private void regraColuna1(String[] values, Long cont, BitCoin bitCoin) {
        BigDecimal soma = BigDecimal.ZERO;
        for(String value : values) {
            soma = RegraUtil.aplicarRegraColuna1(cont, bitCoin, soma, value);
            cont++;
        }
    }



}