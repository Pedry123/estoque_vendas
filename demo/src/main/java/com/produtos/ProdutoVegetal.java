package com.produtos;

public class ProdutoVegetal extends Produto{
    private String tipo; // fruta, verdura, semente, raiz, legume...
    private float peso;


    public ProdutoVegetal(int id, String nome, float preco, int estoque, String validade) {
        super(id, nome, preco, estoque, validade);
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public float getPeso() {
        return peso;
    }


    public void setPeso(float peso) {
        this.peso = peso;
    }


} 
