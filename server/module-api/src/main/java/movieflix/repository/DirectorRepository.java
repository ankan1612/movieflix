package movieflix.repository;

import movieflix.entity.Actor;
import movieflix.entity.Director;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Repository
public class DirectorRepository implements IDirectorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Director> findAll() {
        TypedQuery<Director> query = em.createNamedQuery("Director.findAll",Director.class);
        return  query.getResultList();
    }

    @Override
    public Director findOne(String id) {
        return em.find(Director.class, id);
    }

    @Override
    public List<Director> findbyName(String name) {
        TypedQuery<Director> query = em.createNamedQuery("Director.findByName",Director.class);
        query.setParameter("pName",name);
        return  query.getResultList();
    }

    @Override
    public Director create(Director director) {
        em.persist(director);
        return director;
    }

    @Override
    public Director update(Director director) {
        return em.merge(director);
    }

    @Override
    public void delete(Director director) {
        em.remove(director);
    }
}

