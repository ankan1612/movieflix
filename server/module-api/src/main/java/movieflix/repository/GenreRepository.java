package movieflix.repository;

import movieflix.entity.Country;
import movieflix.entity.Genre;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/27/2017.
 */
@Repository
public class GenreRepository implements IGenreRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findAll",Genre.class);
        return  query.getResultList();
    }

    @Override
    public Genre findOne(String id) {
        return em.find(Genre.class, id);
    }

    @Override
    public Genre findByName(String name) {
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName",Genre.class);
        query.setParameter("pName",name);
        List<Genre> genres =  query.getResultList();
        if(genres!=null && genres.size()==1)
        {
            return genres.get(0);
        }
        return null;
    }

    @Override
    public Genre create(Genre genre) {
        em.persist(genre);
        return genre;
    }

    @Override
    public Genre update(Genre genre) {
        return em.merge(genre);
    }

    @Override
    public void delete(Genre genre) {
        em.remove(genre);
    }
}
