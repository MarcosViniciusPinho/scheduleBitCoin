package br.com.cloudseven.bitcoin.service;

import br.com.cloudseven.bitcoin.dto.BitCoin;

import java.util.List;

/**
 * @author Marcos Pinho
 */
public interface CalculateVariableService {

    void regraColuna1(List<String> values, BitCoin bitCoin);

    void regraColuna2(List<String> values, BitCoin bitCoin);

    void regraColuna3(List<String> values, BitCoin bitCoin);

    void regraColuna4(List<String> values, BitCoin bitCoin);

    void regraColuna5(BitCoin bitCoin);

    void regraColuna6(BitCoin bitCoin);

    void regraColuna7(BitCoin bitCoin);

    void regraColuna8(BitCoin bitCoin);

}