package br.com.cloudseven.bitcoin.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcos Pinho
 */
public class BitCoin {

    private List<String> coluna1;
    private List<String> coluna2;
    private List<String> coluna3;

    public BitCoin() {
        this.coluna1 = new ArrayList<>();
        this.coluna2 = new ArrayList<>();
        this.coluna3 = new ArrayList<>();
    }

    public List<String> getColuna1() {
        return coluna1;
    }

    public List<String> getColuna2() {
        return coluna2;
    }

    public List<String> getColuna3() {
        return coluna3;
    }

}