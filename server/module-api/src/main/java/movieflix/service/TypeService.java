package movieflix.service;


import movieflix.entity.Type;
import movieflix.exception.TypeAlreadyExistsException;
import movieflix.exception.TypeNotFoundException;
import movieflix.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 8/13/2017.
 */
@Service
public class TypeService implements ITypeService {

    @Autowired
    ITypeRepository repository;

    @Override
    public List<Type> findAll() {
        return repository.findAll();
    }

    @Override
    public Type findOne(String id) {
        Type existing = repository.findOne(id);
        if(existing==null) {
            throw new TypeNotFoundException("Type with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    public Type checkByName(String name) {
        Type existing = repository.findByName(name);
        if(existing!=null) {
            return existing;
        }
        return null;
    }

    @Override
    @Transactional
    public Type create(Type type) {
        Type existing = repository.findByName(type.getName());
        if(existing!=null)
        {
            throw new TypeAlreadyExistsException("Type is already in use: " + type.getName());
        }
        return repository.create(type);
    }

    @Override
    @Transactional
    public Type update(String id, Type type) {
        Type existing = repository.findOne(id);
        if(existing==null)
        {
            throw new TypeNotFoundException("Type with id: " + id + " not found");
        }
        return repository.update(type);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Type existing = repository.findOne(id);
        if(existing==null)
        {
            throw new TypeNotFoundException("Type with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
