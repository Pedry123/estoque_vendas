package NotaFiscal;
import Carrinho.Carrinho;
import Produtos.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NotaFiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float valorNota;
    @ElementCollection
    @CollectionTable(name = "nome_produtos", joinColumns = @JoinColumn(name = "nota_fiscal_id"))
    @Column(name = "produto_nome")
    private List<String> nomeProdutos = new ArrayList<>();

    public NotaFiscal(){

    }
    public NotaFiscal(Carrinho carrinho) {
        for(Produto produto : carrinho.getProdutos()){
            nomeProdutos.add(produto.getNome());
        }
        valorNota = carrinho.gerarPrecoTotal();
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
