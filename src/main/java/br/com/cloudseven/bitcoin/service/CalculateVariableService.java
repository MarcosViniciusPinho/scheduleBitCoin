package br.com.cloudseven.bitcoin.service;

import br.com.cloudseven.bitcoin.dto.BitCoin;

/**
 * @author Marcos Pinho
 */
public interface CalculateVariableService {

    void regraColuna1(String[] values, Long cont, BitCoin bitCoin);

    void regraColuna2(String[] values, BitCoin bitCoin);

    void regraColuna3(String[] values, BitCoin bitCoin);

    void regraColuna4(String[] values, BitCoin bitCoin);

    void regraColuna5(Long cont, BitCoin bitCoin);

    void regraColuna6(Long cont, BitCoin bitCoin);

    void regraColuna7(Long cont, BitCoin bitCoin);

}