package Produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Limpeza")
public class ProdutoLimpeza extends Produto {
    private int volume;
    private String finalidade;
    public ProdutoLimpeza(){

    }

    public ProdutoLimpeza(String nome, float preco, int estoque, String validade, int volume, String finalidade) {
        super(nome, preco, estoque, validade);
        this.volume = volume;
        this.finalidade = finalidade;
    }


    public int getVolume() {
        return volume;
    }


    public void setVolume(int volume) {
        this.volume = volume;
    }


    public String getFinalidade() {
        return finalidade;
    }


    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }


}
