package movieflix.service;

import movieflix.entity.Director;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IDirectorService {
    public List<Director> findAll();
    public Director findOne(String id);
    public  Director create(Director director);
    public  Director update(String id, Director director);
    public void  delete(String id);
}
