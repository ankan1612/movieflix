package movieflix.service;

import movieflix.entity.Type;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface ITypeService {
     List<Type> findAll();
    Type findOne(String id);
    Type checkByName(String name);
    Type create(Type type);
    Type update(String id, Type type);
     void  delete(String id);
}
