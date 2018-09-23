package br.com.cloudseven.bitcoin.service;

import br.com.cloudseven.bitcoin.dto.BitCoin;

/**
 * @author Marcos Pinho
 */
public interface CalculateVariableService {

    void regraColuna1(String[] values, Long cont, BitCoin bitCoin);

    void regraColuna2(String[] values, Long cont, BitCoin bitCoin);

    void regraColuna3(String[] values, Long cont, BitCoin bitCoin);

    void regraColuna4(String[] values, Long cont, BitCoin bitCoin);

}