package movieflix.service;

import movieflix.entity.Actor;
import movieflix.exception.ActorNotFoundException;
import movieflix.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Service
public class ActorService implements IActorService {

    @Autowired
    ActorRepository repository;

    @Override
    public List<Actor> findAll() {
        return repository.findAll();
    }

    @Override
    public Actor findOne(String id) {
        Actor existing = repository.findOne(id);
        if(existing==null) {
            throw new ActorNotFoundException("Actor with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Actor create(Actor actor) {
        return repository.create(actor);
    }

    @Override
    @Transactional
    public Actor update(String id, Actor actor) {
        Actor existing = repository.findOne(id);
        if(existing==null)
        {
            throw new ActorNotFoundException("Actor with id: " + id + " not found");
        }
        return repository.update(actor);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Actor existing = repository.findOne(id);
        if(existing==null)
        {
            throw new ActorNotFoundException("Actor with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
