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
    public void regraColuna1(List<String> values, BitCoin bitCoin) {
        Long cont = 0L;
        BigDecimal soma = BigDecimal.ZERO;
        for(String value : values) {
            soma = this.aplicarRegraColuna1(cont, bitCoin, soma, value);
            cont++;
        }
    }

    @Override
    public void regraColuna2(List<String> values, BitCoin bitCoin) {
        this.regraComumDeSubtracao(values, bitCoin.getColuna2());
    }

    @Override
    public void regraColuna3(List<String> values, BitCoin bitCoin) {
        this.regraComumDeSubtracao(values, bitCoin.getColuna3(), 0);
    }

    @Override
    public void regraColuna4(List<String> values, BitCoin bitCoin) {
        for(int i = 0; i < values.size(); i++) {
            if(i > 0) {
                BigDecimal valorAntigo = new BigDecimal(values.get(0));
                BigDecimal valorAtual = new BigDecimal(values.get(i));
                BigDecimal valorCem = BigDecimal.valueOf(100);
                BigDecimal numeroNegativo = BigDecimal.valueOf(-0);

                BigDecimal divisao = valorAtual.divide(valorAntigo, new MathContext(5, RoundingMode.HALF_UP));
                BigDecimal multiplicacao = divisao.multiply(valorCem);
                BigDecimal subtracao = valorCem.subtract(multiplicacao);

                bitCoin.getColuna4().add(numeroNegativo.subtract(subtracao).setScale(2, RoundingMode.HALF_DOWN).toString());
            }
        }
    }

    @Override
    public void regraColuna5(BitCoin bitCoin) {
        this.regraComumDeSomarElementoFixoComOsDemais(bitCoin.getColuna4(), bitCoin.getColuna5());
    }

    @Override
    public void regraColuna6(BitCoin bitCoin) {
        for(int i = 0; i < bitCoin.getColuna4().size(); i++) {
            if(i > 0) {
                String valorAntigoOther = bitCoin.getColuna4().get(i - 1);
                BigDecimal valorAntigo = new BigDecimal(valorAntigoOther);

                String valorAtualOther = bitCoin.getColuna4().get(i);
                BigDecimal valorAtual = new BigDecimal(valorAtualOther);

                BigDecimal soma = valorAntigo.add(valorAtual);
                bitCoin.getColuna6().add(soma.toString());
            }
        }
    }

    @Override
    public void regraColuna7(BitCoin bitCoin) {
        this.regraComumDeSomarElementoFixoComOsDemais(bitCoin.getColuna6(), bitCoin.getColuna7());
    }

    @Override
    public void regraColuna8(BitCoin bitCoin) {

    }

    private void regraComumDeSomarElementoFixoComOsDemais(List<String> colunaParaIterar, List<String> colunaParaAdicionar) {
        Long cont = 0L;
        BigDecimal soma = BigDecimal.ZERO;
        for(String value : colunaParaIterar) {
            BigDecimal valor = new BigDecimal(value);
            soma = soma.add(valor);
            if(cont > 0) {
                colunaParaAdicionar.add(soma.toString());
            }
            cont++;
        }
    }

    private void regraComumDeSubtracao(List<String> values, List<String> coluna) {
        this.regraComumDeSubtracao(values, coluna, null);
    }

    private void regraComumDeSubtracao(List<String> values, List<String> coluna, Integer valorFixo) {
        for(int i = 0; i < values.size(); i++) {
            if(i > 0) {
                String valorAntigoOther = values.get(valorFixo != null ? valorFixo : i - 1);
                BigDecimal valorAntigo = new BigDecimal(valorAntigoOther);

                BigDecimal valorAtual = new BigDecimal(values.get(i));

                BigDecimal subtracao = valorAtual.subtract(valorAntigo);
                coluna.add(subtracao.toString());
            }
        }
    }

    private BigDecimal aplicarRegraColuna1(Long cont, BitCoin bitCoin, BigDecimal soma, String value) {
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