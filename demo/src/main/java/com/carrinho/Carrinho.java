package com.carrinho;
import java.util.ArrayList;

import com.notafiscal.NotaFiscal;
import com.produtos.Produto;

public class Carrinho {
    private String cliente;
    private ArrayList<Produto> produtos;
    private float preco;
    private String cpf;

    
    public Carrinho(String cliente, float preco) {
        this.cliente = cliente;
        this.preco = preco;
        this.produtos = new ArrayList<Produto>();
    }


    public Carrinho(String cliente, float preco, String cpf) {
        this.cliente = cliente;
        this.preco = preco;
        this.cpf = cpf;
        this.produtos = new ArrayList<Produto>();
    }


    public String getCliente() {
        return cliente;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    public ArrayList<Produto> getProdutos() {
        return produtos;
    }


    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }


    public float getPreco() {
        return preco;
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }


    public String getCpf() {
        return cpf;
    }


    public float aumentarPrecoTotal(Produto produto) {
        this.preco += produto.getPreco();
        return this.preco;
    }


    public float diminuirPrecoTotal(Produto produto) {
        this.preco -= produto.getPreco();
        return this.preco;
    }

    
    public void adicionarProdutoAoCarrinho(Produto produto) {
        this.produtos.add(produto);
        aumentarPrecoTotal(produto);
    }

    
    public void removerProdutoDoCarrinho(Produto produto) {
        this.produtos.remove(produto);
        diminuirPrecoTotal(produto);
    }


    public NotaFiscal finalizarCompra(NotaFiscal notaFiscal) {
        return notaFiscal;
    }


}



