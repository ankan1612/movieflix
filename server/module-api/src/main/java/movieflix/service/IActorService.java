package movieflix.service;

import movieflix.entity.Actor;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IActorService {
    public List<Actor> findAll();
    public Actor findOne(String id);
    public  Actor create(Actor actor);
    public  Actor update(String id, Actor actor);
    public void  delete(String id);
}
