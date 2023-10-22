package com.carrinho;
import java.util.ArrayList;

import com.caixas.CaixaMercado;
import com.notafiscal.NotaFiscal;
import com.produtos.Produto;

public class Carrinho {
    private String cliente;
    private ArrayList<Produto> produtos;
    private ArrayList<Float> precos;
    private String cpf;

    
    public Carrinho(String cliente) {
        this.cliente = cliente;
        
        this.produtos = new ArrayList<Produto>();
        this.precos = new ArrayList<Float>();
    }


    public Carrinho(String cliente, String cpf) {
        this.cliente = cliente;
        this.cpf = cpf;

        this.produtos = new ArrayList<Produto>();
        this.precos = new ArrayList<Float>();
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


    public ArrayList<Float> getPrecos() {
        return precos;
    }


    public void setPrecos(ArrayList<Float> precos) {
        this.precos = precos;
    }


    public String getCpf() {
        return cpf;
    }


    public void adicionarProdutoAoCarrinho(Produto produto) {
        this.produtos.add(produto);
        this.precos.add(produto.getPreco());
    }

    
    public void removerProdutoDoCarrinho(Produto produto) {
        this.produtos.remove(produto);
        this.precos.remove(produto.getPreco());
    }


    public float gerarPrecoTotal() {
        float precoTotal = 0;
        for (float preco : precos) {
            precoTotal += preco;
        }
        return precoTotal;
    }


    public NotaFiscal finalizarCompra(CaixaMercado caixa, int id) {
        float precoTotal = this.gerarPrecoTotal();
        caixa.setValorCaixa(caixa.getValorCaixa() + precoTotal);
        produtos.clear();
        precos.clear();
        return new NotaFiscal(id, this);
    }


}



