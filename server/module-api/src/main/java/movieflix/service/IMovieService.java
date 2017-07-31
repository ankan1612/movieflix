package movieflix.service;

import movieflix.entity.Movie;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IMovieService {
     List<Movie> findAll();
     Movie findOne(String id);
    List<Movie> findbyTitle(String name);
    Movie create(Movie movie);
      Movie update(String id, Movie movie);
     void  delete(String id);
}
