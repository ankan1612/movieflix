package movieflix.repository;

import movieflix.entity.Actor;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IActorRepository {
    public List<Actor> findAll();
    public Actor findOne(String id);
    public  Actor create(Actor emp);
    public  Actor update(Actor emp);
    public void  delete(Actor emp);
}
