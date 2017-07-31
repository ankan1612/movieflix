package movieflix.repository;

import movieflix.entity.*;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IRatingRepository {
    public List<Rating> findAll();
    public Rating findOne(RatingId id);
    public List<Rating> findByMovie(Movie movie);
    public List<Rating> findByUser(User user);
    public List<Double> getAverageByMovie(Movie movie);
    public  Rating create(Rating rating);
    public  Rating update(Rating rating);
    public void  delete(Rating rating);
    public int  deleteByMovie(Movie movie);
    public int  deleteByUser(User user);
}
