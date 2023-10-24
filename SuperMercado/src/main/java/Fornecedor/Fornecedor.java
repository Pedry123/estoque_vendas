package Fornecedor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fornecedores")
public class Fornecedor {
    @Id
    private String cnpj;
    private String nome;
    private String tipoProduto;
    private float custo;
    private String origem;

    public Fornecedor(){

    }
    public Fornecedor(String nome, String tipoProduto, String cnpj, float custo, String origem) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.cnpj = cnpj;
        this.custo = custo;
        this.origem = origem;
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
