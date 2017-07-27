package movieflix.service;

import movieflix.entity.Genre;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface IGenreService {
    public List<Genre> findAll();
    public Genre findOne(String id);
    public  Genre create(Genre genre);
    public  Genre update(String id, Genre genre);
    public void  delete(String id);
}
