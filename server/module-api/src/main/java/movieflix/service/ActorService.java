package movieflix.service;

import movieflix.entity.Actor;
import movieflix.exception.ActorAlreadyExistsException;
import movieflix.exception.ActorNotFoundException;
import movieflix.exception.UserAlreadyExistsException;
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
    public List<Actor> findByName(String name) {
        List<Actor> existing = repository.findbyName(name);
        if(existing==null) {
            throw new ActorNotFoundException("Actor with name: " + name + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Actor create(Actor actor) {
        Actor existing = repository.findOne(actor.getActorId());
        if(existing!=null)
        {
            throw new ActorAlreadyExistsException("Actor is already in use: " + actor.getActorId() + " " + actor.getName());
        }
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
