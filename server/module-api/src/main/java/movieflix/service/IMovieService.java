package movieflix.service;

import movieflix.entity.Movie;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IMovieService {
    public List<Movie> findAll();
    public Movie findOne(String id);
    public  Movie create(Movie movie);
    public  Movie update(String id, Movie movie);
    public void  delete(String id);
}
