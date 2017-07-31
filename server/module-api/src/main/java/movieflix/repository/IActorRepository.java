package movieflix.repository;

import movieflix.entity.Actor;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IActorRepository {
    public List<Actor> findAll();
    public Actor findOne(String id);
    public List<Actor> findbyName(String name);
    public  Actor create(Actor actor);
    public  Actor update(Actor actor);
    public void  delete(Actor actor);
}
