package movieflix.repository;

import movieflix.entity.Type;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface ITypeRepository {
     List<Type> findAll();
     Type findOne(String id);
     Type findByName(String name);
      Type create(Type type);
      Type update(Type type);
     void  delete(Type type);
}
