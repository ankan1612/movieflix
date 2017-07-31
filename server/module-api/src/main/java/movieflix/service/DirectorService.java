package movieflix.service;

import movieflix.entity.Director;
import movieflix.exception.ActorAlreadyExistsException;
import movieflix.exception.ActorNotFoundException;
import movieflix.exception.DirectorAlreadyExistsException;
import movieflix.exception.DirectorNotFoundException;
import movieflix.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Service
public class DirectorService implements IDirectorService {

    @Autowired
    DirectorRepository repository;

    @Override
    public List<Director> findAll() {
        return repository.findAll();
    }

    @Override
    public Director findOne(String id) {
        Director existing = repository.findOne(id);
        if(existing==null) {
            throw new DirectorNotFoundException("Director with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    public List<Director> findByName(String name) {
        List<Director> existing = repository.findbyName(name);
        if(existing==null) {
            throw new DirectorNotFoundException("Director with name: " + name + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Director create(Director director) {
        Director existing = repository.findOne(director.getDirectorId());
        if(existing!=null)
        {
            throw new DirectorAlreadyExistsException("Director is already in use: " + director.getDirectorId() + " " + director.getName());
        }
        return repository.create(director);
    }

    @Override
    @Transactional
    public Director update(String id, Director director) {
        Director existing = repository.findOne(id);
        if(existing==null)
        {
            throw new DirectorNotFoundException("Director with id: " + id + " not found");
        }
        return repository.update(director);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Director existing = repository.findOne(id);
        if(existing==null)
        {
            throw new DirectorNotFoundException("Director with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
