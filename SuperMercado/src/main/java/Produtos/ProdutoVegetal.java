package Produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vegetal")
public class ProdutoVegetal extends Produto{
    private String tipo; // fruta, verdura, semente, raiz, legume...
    private float peso;

    public ProdutoVegetal(){

    }
    public ProdutoVegetal(String nome, float preco, int estoque, String validade, String tipo, float peso) {
        super(nome, preco, estoque, validade);
        this.tipo = tipo;
        this.peso = peso;
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
