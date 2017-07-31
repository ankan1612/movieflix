package movieflix.service;

import movieflix.entity.Genre;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface IGenreService {
    List<Genre> findAll();
    Genre findOne(String id);
    Genre findByName(String name);
    Genre create(Genre genre);
    Genre update(String id, Genre genre);
    void  delete(String id);
}
