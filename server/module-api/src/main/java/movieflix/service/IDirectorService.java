package movieflix.service;

import movieflix.entity.Director;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IDirectorService {
     List<Director> findAll();
     Director findOne(String id);

    Director checkByName(String name);

    List<Director> findByName(String name);
      Director create(Director director);
      Director update(String id, Director director);
     void  delete(String id);
}
