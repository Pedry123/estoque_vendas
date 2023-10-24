package Funcionarios;

import Funcionarios.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public FuncionarioDAO() {
        factory = Persistence.createEntityManagerFactory("supermercado");
        entityManager = factory.createEntityManager();
    }

    public void salvarFuncionario(Funcionario funcionario) {
        entityManager.getTransaction().begin();
        Funcionario FuncionarioExiste = entityManager.find(Funcionario.class, funcionario.getCpf());
        if(FuncionarioExiste == null) {
            entityManager.persist(funcionario);
        }
        else{
            System.out.println("CPF de funcionário já existe");
        }
        entityManager.getTransaction().commit();
    }

    public Funcionario buscarFuncionarioPorCPF(String cpf) {
        return entityManager.find(Funcionario.class, cpf);
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = entityManager.createQuery("SELECT f FROM Funcionarios.Funcionario f", Funcionario.class).getResultList();

        for (Funcionario funcionario : funcionarios) {
            System.out.println("CPF: " + funcionario.getCpf());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Departamento: " + funcionario.getDepartamento());
            System.out.println("-----------------------------------");
        }

        return funcionarios;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        entityManager.getTransaction().begin();
        entityManager.merge(funcionario);
        entityManager.getTransaction().commit();
    }

    public void removerFuncionario(String cpf) {
        Funcionario funcionario = buscarFuncionarioPorCPF(cpf);
        if (funcionario != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
        }
    }
    public void apagarTodosFuncionarios() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Funcionarios.Funcionario").executeUpdate();
        entityManager.getTransaction().commit();
    }
}
