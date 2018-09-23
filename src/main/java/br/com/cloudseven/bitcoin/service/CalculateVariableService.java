package br.com.cloudseven.bitcoin.service;

import br.com.cloudseven.bitcoin.dto.BitCoin;

import java.math.BigDecimal;

/**
 * @author Marcos Pinho
 */
public interface CalculateVariableService {

    BigDecimal aplicarRegraColuna1(Long cont, BitCoin bitCoin, BigDecimal soma,
                                   String value);

}