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
    private List<String> coluna4;
    private List<String> coluna5;
    private List<String> coluna6;
    private List<String> coluna7;

    public BitCoin() {
        this.coluna1 = new ArrayList<>();
        this.coluna2 = new ArrayList<>();
        this.coluna3 = new ArrayList<>();
        this.coluna4 = new ArrayList<>();
        this.coluna5 = new ArrayList<>();
        this.coluna6 = new ArrayList<>();
        this.coluna7 = new ArrayList<>();
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

    public List<String> getColuna4() {
        return coluna4;
    }

    public List<String> getColuna5() {
        return coluna5;
    }

    public List<String> getColuna6() {
        return coluna6;
    }

    public List<String> getColuna7() {
        return coluna7;
    }
}