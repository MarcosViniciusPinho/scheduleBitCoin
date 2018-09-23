package br.com.cloudseven.bitcoin.service.impl;

import br.com.cloudseven.bitcoin.dto.BitCoin;
import br.com.cloudseven.bitcoin.service.CalculateVariableService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Marcos Pinho
 */
@Service
public class CalculateVariableServiceImpl implements CalculateVariableService {

    @Override
    public void regraColuna1(String[] values, Long cont, BitCoin bitCoin) {
        BigDecimal soma = BigDecimal.ZERO;
        for(String value : values) {
            soma = this.aplicarRegraColuna1(cont, bitCoin, soma, value);
            cont++;
        }
    }

    @Override
    public void regraColuna2(String[] values, Long cont, BitCoin bitCoin) {
        this.regraComumDeSubtracao(values, cont, bitCoin.getColuna2());
    }

    @Override
    public void regraColuna3(String[] values, Long cont, BitCoin bitCoin) {
        this.regraComumDeSubtracao(values, cont, bitCoin.getColuna3(), 0);
    }

    @Override
    public void regraColuna4(String[] values, Long cont, BitCoin bitCoin) {
        for(int i = 0; i < values.length; i++) {
            if(cont > 0) {
                BigDecimal valorAntigo = new BigDecimal(values[0]);
                BigDecimal valorAtual = new BigDecimal(values[i]);
                BigDecimal valorCem = BigDecimal.valueOf(100);
                BigDecimal numeroNegativo = BigDecimal.valueOf(-0);

                BigDecimal divisao = valorAtual.divide(valorAntigo, new MathContext(5, RoundingMode.UP));
                BigDecimal multiplicacao = divisao.multiply(valorCem);
                BigDecimal subtracao = valorCem.subtract(multiplicacao);

                bitCoin.getColuna4().add(String.format("%.2f", numeroNegativo.subtract(subtracao)));
            }
            cont++;
        }
    }

    private void regraComumDeSubtracao(String[] values, Long cont, List<String> coluna) {
        this.regraComumDeSubtracao(values, cont, coluna, null);
    }

    private void regraComumDeSubtracao(String[] values, Long cont, List<String> coluna, Integer valorFixo) {
        for(int i = 0; i < values.length; i++) {
            if(cont > 0) {
                BigDecimal valorAntigo = new BigDecimal(values[valorFixo != null ? valorFixo : i - 1]);
                BigDecimal valorAtual = new BigDecimal(values[i]);

                BigDecimal subtracao = valorAtual.subtract(valorAntigo);
                coluna.add(String.format("%.6f", subtracao));
            }
            cont++;
        }
    }

    private BigDecimal aplicarRegraColuna1(Long cont, BitCoin bitCoin, BigDecimal soma, String value) {
        BigDecimal valor = new BigDecimal(value);
        soma = soma.add(valor);
        if(cont > 0) {
            BigDecimal total = soma.divide(BigDecimal.valueOf(cont + 1),
                    new MathContext(5, RoundingMode.HALF_UP));

            bitCoin.getColuna1().add(String.format("%.6f", total));
        }
        return soma;
    }

}