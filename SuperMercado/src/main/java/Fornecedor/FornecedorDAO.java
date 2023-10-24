package Fornecedor;
import Funcionarios.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FornecedorDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public FornecedorDAO() {
        factory = Persistence.createEntityManagerFactory("supermercado");
        entityManager = factory.createEntityManager();
    }

    public void salvarFornecedor(Fornecedor fornecedor) {
        entityManager.getTransaction().begin();
        Fornecedor fornecedorExiste = buscarFornecedorPorCnpj(fornecedor.getCnpj());
        if(fornecedorExiste == null) {
            entityManager.persist(fornecedor);
        }
        else{
            System.out.println("Cnpj de fornecedor já existe");
        }
        entityManager.getTransaction().commit();
    }

    public Fornecedor buscarFornecedorPorCnpj(String cnpj) {
        return entityManager.find(Fornecedor.class, cnpj);
    }

    public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = entityManager.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class).getResultList();

        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("CNPJ: " + fornecedor.getCnpj());
            System.out.println("Nome: " + fornecedor.getNome());
            System.out.println("Tipo de Produto: " + fornecedor.getTipoProduto());
            System.out.println("Custo: " + fornecedor.getCusto());
            System.out.println("Origem: " + fornecedor.getOrigem());
            System.out.println("-----------------------------------");
        }

        return fornecedores;
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        entityManager.getTransaction().begin();
        entityManager.merge(fornecedor);
        entityManager.getTransaction().commit();
    }

    public void removerFornecedor(String cnpj) {
        Fornecedor fornecedor = buscarFornecedorPorCnpj(cnpj);
        if (fornecedor != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
        }
    }
}
