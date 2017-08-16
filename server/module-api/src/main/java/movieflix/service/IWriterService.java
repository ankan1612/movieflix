package movieflix.service;

import movieflix.entity.Writer;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IWriterService {
     List<Writer> findAll();
     Writer findOne(String id);

    Writer checkByName(String name);

    List<Writer> findByName(String name);
    Writer create(Writer writer);
      Writer update(String id, Writer writer);
     void  delete(String id);
}
