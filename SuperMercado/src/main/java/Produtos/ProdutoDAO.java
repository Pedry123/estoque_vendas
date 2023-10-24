package Produtos;
import javax.persistence.*;
import java.util.List;

public class ProdutoDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public ProdutoDAO() {
        factory = Persistence.createEntityManagerFactory("supermercado");
        entityManager = factory.createEntityManager();
    }

    public void salvarProduto(Produto produto) {
        entityManager.getTransaction().begin();
        Produto produtoExiste = buscarProdutoPorNome(produto.getNome());
        if(produtoExiste == null) {
            entityManager.persist(produto);
        }
        else{
            System.out.println("Produto já existe");
        }
        entityManager.getTransaction().commit();
    }

    public Produto buscarProdutoPorNome(String nome) {
        return entityManager.find(Produto.class, nome);
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();

        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Estoque: " + produto.getEstoque());
            System.out.println("Validade: " + produto.getValidade());

            if (produto instanceof ProdutoCarne) {
                ProdutoCarne carne = (ProdutoCarne) produto;
                System.out.println("Corte: " + carne.getCorte());
                System.out.println("Peso: " + carne.getPeso());
            } else if (produto instanceof ProdutoLimpeza) {
                ProdutoLimpeza limpeza = (ProdutoLimpeza) produto;
                System.out.println("Volume: " + limpeza.getVolume());
                System.out.println("Finalidade: " + limpeza.getFinalidade());
            } else if (produto instanceof ProdutoVegetal){
                ProdutoVegetal vegetal = (ProdutoVegetal) produto;
                System.out.println("Tipo: " + vegetal.getTipo());
                System.out.println("Peso: " + vegetal.getPeso());
            }

            System.out.println("-----------------------------------");
        }

        return produtos;
    }

    public void atualizarProduto(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
    }

    public void removerProduto(String nome) {
        Produto produto = buscarProdutoPorNome(nome);
        if (produto != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
        }
    }
}
