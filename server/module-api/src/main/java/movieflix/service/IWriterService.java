package movieflix.service;

import movieflix.entity.Writer;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IWriterService {
    public List<Writer> findAll();
    public Writer findOne(String id);
    public  Writer create(Writer writer);
    public  Writer update(String id, Writer writer);
    public void  delete(String id);
}
