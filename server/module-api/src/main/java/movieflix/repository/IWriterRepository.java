package movieflix.repository;

import movieflix.entity.Writer;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IWriterRepository {
    public List<Writer> findAll();
    public Writer findOne(String id);
    public List<Writer> findbyName(String name);
    public  Writer create(Writer writer);
    public  Writer update(Writer writer);
    public void  delete(Writer writer);
}
