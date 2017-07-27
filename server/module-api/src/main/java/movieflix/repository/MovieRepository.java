package movieflix.repository;

import movieflix.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Repository
public class MovieRepository implements IMovieRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> findAll() {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll",Movie.class);
        return  query.getResultList();
    }

    @Override
    public Movie findOne(String id) {
        return em.find(Movie.class, id);
    }

    @Override
    public Movie create(Movie movie) {
        em.persist(movie);
        return movie;
    }

    @Override
    public Movie update(Movie movie) {
        return em.merge(movie);
    }

    @Override
    public void delete(Movie movie) {
        em.remove(movie);
    }
}

