package movieflix.service;

import movieflix.entity.Actor;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IActorService {
     List<Actor> findAll();
     Actor findOne(String id);
     List<Actor> findByName(String name);
      Actor create(Actor actor);
      Actor update(String id, Actor actor);
     void  delete(String id);
}
