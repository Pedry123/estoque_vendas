package Caixas;

import Fornecedor.Fornecedor;
import Funcionarios.Funcionario;

import javax.persistence.*;

@Entity
@Table(name="Caixa")
public class CaixaMercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float valorCaixa;
    @OneToOne
    private Funcionario dono;
    private float despesas;

    public CaixaMercado(){

    }
    public CaixaMercado(float valorCaixa, Funcionario dono, float despesas) {
        this.valorCaixa = valorCaixa;
        this.dono = dono;
        this.despesas = despesas;
    }


    public float getValorCaixa() {
        return valorCaixa;
    }


    public void setValorCaixa(float valorCaixa) {
        this.valorCaixa = valorCaixa;
    }


    public Funcionario getDono() {
        return dono;
    }


    public void setDono(Funcionario dono) {
        this.dono = dono;
    }


    public float getDespesas() {
        return despesas;
    }


    public void setDespesas(float despesas) {
        this.despesas = despesas;
    }


    public void comprarProdutoDeFornecedor(Fornecedor fornecedor){
        this.valorCaixa -= fornecedor.getCusto();
    }

    public void receberPagamento(float valor){
        this.valorCaixa += valor;
    }

}
