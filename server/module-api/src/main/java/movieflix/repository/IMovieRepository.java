package movieflix.repository;

import movieflix.entity.Movie;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
public interface IMovieRepository {
    public List<Movie> findAll();
    public  Movie findOne(String id);
    public List<Movie> findbyTitle(String name);
    public  Movie create(Movie movie);
    public  Movie update(Movie movie);
    public void  delete(Movie movie);
}
