package movieflix.repository;

import movieflix.entity.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Repository
public class ActorRepository implements IActorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Actor> findAll() {
        TypedQuery<Actor> query = em.createNamedQuery("Actor.findAll",Actor.class);
        return  query.getResultList();
    }

    @Override
    public Actor findOne(String id) {
        return em.find(Actor.class, id);
    }

    @Override
    public Actor create(Actor actor) {
        em.persist(actor);
        return actor;
    }

    @Override
    public Actor update(Actor actor) {
        return em.merge(actor);
    }

    @Override
    public void delete(Actor actor) {
        em.remove(actor);
    }
}

