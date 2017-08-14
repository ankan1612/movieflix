package movieflix.service;

import movieflix.entity.Movie;
import movieflix.entity.Rating;
import movieflix.entity.RatingId;
import movieflix.entity.User;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
public interface IRatingService {
     List<Rating> findAll();
     Rating findOne(String id);
     RatingId getRatingId(String id);
     List<Rating> findByMovie(Movie movie);

    List<Rating> findByMovie(String id);

    List<Rating> findByUser(User user);
     List<Double> getAverageByMovie(Movie movie);
     Rating create(Rating rating);
     Rating update(String id, Rating rating);
     void  delete(String  id);
     boolean  deleteByMovie(Movie movie);
     boolean  deleteByUser(User user);
}
