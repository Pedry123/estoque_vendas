package NotaFiscal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotaFiscalDAO {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public NotaFiscalDAO() {
        factory = Persistence.createEntityManagerFactory("supermercado");
        entityManager = factory.createEntityManager();
    }

    public void close() {
        entityManager.close();
        factory.close();
    }

    public void salvarNotaFiscal(NotaFiscal notaFiscal) {
        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();
    }

    public NotaFiscal buscarNotaFiscalPorId(int id) {
        return entityManager.find(NotaFiscal.class, id);
    }

    public List<NotaFiscal> listarNotasFiscais() {
        TypedQuery<NotaFiscal> query = entityManager.createQuery("SELECT nf FROM NotaFiscal nf", NotaFiscal.class);
        return query.getResultList();
    }

    public void removerNotaFiscal(int id) {
        NotaFiscal notaFiscal = buscarNotaFiscalPorId(id);
        if (notaFiscal != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(notaFiscal);
            entityManager.getTransaction().commit();
        }
    }
}
