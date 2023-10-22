package com.fornecedores;

public class Fornecedor {
    private String nome;
    private String tipoProduto;
    private String cnpj;
    private float custo;
    private String origem;


    public Fornecedor(String nome, String tipoProduto, String cnpj, float custo, String origem) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.cnpj = cnpj;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTipoProduto() {
        return tipoProduto;
    }


    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }


    public String getCnpj() {
        return cnpj;
    }

    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public float getCusto() {
        return custo;
    }


    public void setCusto(float custo) {
        this.custo = custo;
    }


    public String getOrigem() {
        return origem;
    }


    public void setOrigem(String origem) {
        this.origem = origem;
    }
    

}
