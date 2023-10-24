package Produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Carne")
public class ProdutoCarne extends Produto {
    private String corte;
    private float peso;

    public ProdutoCarne(){

    }
    public ProdutoCarne(String nome, float preco, int estoque, String validade, String corte, float peso) {
        super(nome, preco, estoque, validade);
        this.corte = corte;
        this.peso = peso;
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
