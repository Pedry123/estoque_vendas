package com.produtos;

public class ProdutoLimpeza extends Produto {
    private int volume;
    private String finalidade;


    public ProdutoLimpeza(int id, String nome, float preco, int estoque, String validade) {
        super(id, nome, preco, estoque, validade);
    }


    public int getVolume() {
        return volume;
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }


    public String getFinalidade() {
        return finalidade;
    }


    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }


}
