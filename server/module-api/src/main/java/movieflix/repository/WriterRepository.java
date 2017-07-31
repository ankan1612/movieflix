package movieflix.repository;

import movieflix.entity.Writer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Repository
public class WriterRepository implements IWriterRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Writer> findAll() {
        TypedQuery<Writer> query = em.createNamedQuery("Writer.findAll",Writer.class);
        return  query.getResultList();
    }

    @Override
    public Writer findOne(String id) {
        return em.find(Writer.class, id);
    }

    @Override
    public List<Writer> findbyName(String name) {
        TypedQuery<Writer> query = em.createNamedQuery("Writer.findByName",Writer.class);
        query.setParameter("pName",name);
        return  query.getResultList();
    }

    @Override
    public Writer create(Writer writer) {
        em.persist(writer);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        return em.merge(writer);
    }

    @Override
    public void delete(Writer writer) {
        em.remove(writer);
    }
}

