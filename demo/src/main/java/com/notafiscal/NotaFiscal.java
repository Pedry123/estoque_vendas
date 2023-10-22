package com.notafiscal;

import com.carrinho.Carrinho;

public class NotaFiscal {
    private int id;
    private Carrinho carrinho;


    public NotaFiscal(int id, Carrinho carrinho) {
        this.id = id;
        this.carrinho = carrinho;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Carrinho getCarrinho() {
        return carrinho;
    }


    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }


}
