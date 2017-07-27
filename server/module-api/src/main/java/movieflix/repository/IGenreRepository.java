package movieflix.repository;

import movieflix.entity.Genre;

import java.util.List;

/**
 * Created by Ankan on 7/27/2017.
 */
public interface IGenreRepository {
    public List<Genre> findAll();
    public Genre findOne(String id);
    public Genre findByName(String name);
    public  Genre create(Genre genre);
    public  Genre update(Genre genre);
    public void  delete(Genre genre);
}
