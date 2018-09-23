package br.com.cloudseven.bitcoin.service.impl.util;

import br.com.cloudseven.bitcoin.dto.BitCoin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author Marcos Pinho
 */
public class RegraUtil {

    public static BigDecimal aplicarRegraColuna1(Long cont, BitCoin bitCoin, BigDecimal soma,
                                           String value) {
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