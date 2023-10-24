package Produtos;

import javax.persistence.*;
import NotaFiscal.NotaFiscal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
public class Produto {
    @Id
    private String nome;
    private float preco;
    private int estoque;
    private String validade;
    public Produto(){

    }
    public Produto(String nome, float preco, int estoque, String validade) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.validade = validade;
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
        if (this.estoque < 0) {
            this.estoque = 0;
        }
    }


    public String getValidade() {
        return validade;
    }


    public void setValidade(String validade) {
        this.validade = validade;
    }


}
