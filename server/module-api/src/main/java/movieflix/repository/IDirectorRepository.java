package movieflix.repository;

import movieflix.entity.Director;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IDirectorRepository {
    public List<Director> findAll();
    public Director findOne(String id);
    public List<Director> findbyName(String name);
    public  Director create(Director director);
    public  Director update(Director director);
    public void  delete(Director director);
}
