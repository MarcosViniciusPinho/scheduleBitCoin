package br.com.cloudseven.bitcoin.service;

import br.com.cloudseven.bitcoin.dto.BitCoin;

import java.util.List;

/**
 * @author Marcos Pinho
 */
public interface CalculateVariableService {

    void aplicarRegras(List<String> values, BitCoin bitCoin);

}