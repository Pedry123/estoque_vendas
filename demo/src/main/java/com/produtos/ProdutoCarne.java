package com.produtos;

public class ProdutoCarne extends Produto {
    private String corte;
    private float peso;

    
    public ProdutoCarne(int id, String nome, float preco, int estoque, String validade, String corte) {
        super(id, nome, preco, estoque, validade);
        this.corte = corte;
    }


    public String getCorte() {
        return corte;
    }


    public void setCorte(String corte) {
        this.corte = corte;
    }


    public float getPeso() {
        return peso;
    }


    public void setPeso(float peso) {
        this.peso = peso;
    }


}
