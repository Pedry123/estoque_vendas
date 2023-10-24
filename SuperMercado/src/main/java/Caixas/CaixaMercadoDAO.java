package Caixas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CaixaMercadoDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public CaixaMercadoDAO() {
        factory = Persistence.createEntityManagerFactory("supermercado");
        entityManager = factory.createEntityManager();
    }

    public void salvarCaixaMercado(CaixaMercado caixaMercado) {
        entityManager.getTransaction().begin();
        entityManager.persist(caixaMercado);
        entityManager.getTransaction().commit();
    }

    public CaixaMercado buscarCaixaMercadoPorId(int id) {
        return entityManager.find(CaixaMercado.class, id);
    }

    public void atualizarCaixaMercado(CaixaMercado caixaMercado) {
        entityManager.getTransaction().begin();
        entityManager.merge(caixaMercado);
        entityManager.getTransaction().commit();
    }

    public void removerCaixaMercado(int id) {
        CaixaMercado caixaMercado = buscarCaixaMercadoPorId(id);
        if (caixaMercado != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(caixaMercado);
            entityManager.getTransaction().commit();
        }
    }
}
