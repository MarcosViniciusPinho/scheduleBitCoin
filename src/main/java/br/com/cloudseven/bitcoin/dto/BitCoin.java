package br.com.cloudseven.bitcoin.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcos Pinho
 */
public class BitCoin {

    private List<String> coluna1;

    public BitCoin() {
        this.coluna1 = new ArrayList<>();
    }

    public List<String> getColuna1() {
        return coluna1;
    }

}