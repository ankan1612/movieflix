package movieflix.repository;

import movieflix.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Repository
public class RatingRepository implements IRatingRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Rating> findAll() {
        TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll",Rating.class);
        return  query.getResultList();
    }

    @Override
    public Rating findOne(RatingId id) {
        return em.find(Rating.class, id);
    }

    @Override
    public List<Rating> findByMovie(Movie movie) {
        TypedQuery<Rating> query = em.createNamedQuery("Rating.findByMovie",Rating.class);
        query.setParameter("pName",movie);
        return  query.getResultList();
    }

    @Override
    public List<Rating> findByUser(User user) {
        TypedQuery<Rating> query = em.createNamedQuery("Rating.findByUser",Rating.class);
        query.setParameter("pName",user);
        return  query.getResultList();
    }

    @Override
    public List<Double> getAverageByMovie(Movie movie) {
        TypedQuery<Double> query = em.createNamedQuery("Rating.getAverageByMovie",Double.class);
        query.setParameter("pName",movie);
        return  query.getResultList();
    }

    @Override
    public Rating create(Rating rating) {
        em.persist(rating);
        return rating;
    }

    @Override
    public Rating update(Rating rating) {
        return em.merge(rating);
    }

    @Override
    public void delete(Rating rating) {
        em.remove(rating);
    }

    @Override
    public int deleteByMovie(Movie movie) {
        Query query = em.createNamedQuery("Rating.deleteByMovie");
        query.setParameter("pName",movie);
        return query.executeUpdate();
    }

    @Override
    public int deleteByUser(User user) {
        Query query = em.createNamedQuery("Rating.deleteByUser");
        query.setParameter("pName",user);
        return query.executeUpdate();
    }
}

