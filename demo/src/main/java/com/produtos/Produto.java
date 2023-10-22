package com.produtos;

public class Produto {
    private int id;
    private String nome;
    private float preco;
    private int estoque;
    private String validade;
   


    public Produto(int id, String nome, float preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }


    public Produto(int id, String nome, float preco, int estoque, String validade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public float getPreco() {
        return preco;
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }


    public int getEstoque() {
        return estoque;
    }


    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    public String getValidade() {
        return validade;
    }


    public void setValidade(String validade) {
        this.validade = validade;
    }

    
}
