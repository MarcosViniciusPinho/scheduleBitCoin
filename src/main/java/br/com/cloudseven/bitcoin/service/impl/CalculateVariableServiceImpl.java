package br.com.cloudseven.bitcoin.service.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.service.CalculateVariableService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author Marcos Pinho
 */
@Service
public class CalculateVariableServiceImpl implements CalculateVariableService {

    @Override
    public BigDecimal aplicarRegraColuna1(Long cont, BitCoin bitCoin, BigDecimal soma, String value) {
        BigDecimal valor = new BigDecimal(value);
        soma = soma.add(valor);
        if(cont > 0) {
            BigDecimal total = soma.divide(BigDecimal.valueOf(cont + 1),
                    new MathContext(5, RoundingMode.HALF_UP));

            bitCoin.getColuna1().add(total.toString());
        }
        return soma;
    }

}