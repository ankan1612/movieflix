package movieflix.service;

import movieflix.entity.Movie;

import movieflix.entity.Rating;
import movieflix.entity.RatingId;
import movieflix.entity.User;
import movieflix.exception.RatingAlreadyExistsException;
import movieflix.exception.RatingNotFoundException;
import movieflix.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Service
public class RatingService implements IRatingService {

    @Autowired
    IRatingRepository repository;

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public RatingId getRatingId(String id) {
        String ids[] = id.split("&");
        if(ids.length!=2)
        {
            throw new RatingNotFoundException("Rating with id: " + id  +" not found");
        }
        Movie m = movieRepository.findOne(ids[0]);
        User u = userRepository.findOne(ids[1]);
        if(m==null && u==null)
        {
            throw new RatingNotFoundException("Rating with movie: " + ids[0] + "and user: "+ ids[1]  +" not found");
        }
        return new RatingId(m,u);
    }

    @Override
    public List<Rating> findAll() {
        return repository.findAll();
    }

    @Override
    public Rating findOne(String id) {
        RatingId ratingId = getRatingId(id);
        Rating existing = repository.findOne(ratingId);
        if(existing==null) {
            throw new RatingNotFoundException("Rating with movie: " + ratingId.getMovie().getTitle() + "and user: "+ ratingId.getUser().getEmail()  +" not found");
        }
        return existing;
    }

    @Override
    public List<Rating> findByMovie(Movie movie) {
        List<Rating> existing = repository.findByMovie(movie);
        if(existing.size()<1) {
            throw new RatingNotFoundException("Rating with movie: " + movie.getTitle() +" not found");
        }
        return existing;
    }

    @Override
    public List<Rating> findByUser(User user) {
        List<Rating> existing = repository.findByUser(user);
        if(existing.size()<1) {
            throw new RatingNotFoundException("Rating with user: " + user.getEmail() +" not found");
        }
        return existing;
    }

    @Override
    public List<Double> getAverageByMovie(Movie movie) {
        List<Double> existing = repository.getAverageByMovie(movie);
        if(existing.size()<1) {
            throw new RatingNotFoundException("Rating with movie: " + movie.getTitle() +" not found");
        }
        return existing;
    }

    @Transactional
    @Override
    public Rating create(Rating rating) {
        Rating existing = repository.findOne(rating.getId());
        if(existing!=null)
        {
            throw new RatingAlreadyExistsException("Rating with movie: " + rating.getId().getMovie().getTitle() + "and user: "+ rating.getId().getUser().getEmail()  +" not found");
        }
        return repository.create(rating);
    }

    @Transactional
    @Override
    public Rating update(String id,Rating rating) {
        RatingId ratingId = getRatingId(id);
        Rating existing = repository.findOne(ratingId);
        if(existing==null)
        {
            throw new RatingNotFoundException("Rating with movie: " + ratingId.getMovie().getTitle() + "and user: "+ ratingId.getUser().getEmail()  +" not found");
        }
        return repository.update(rating);
    }
    @Transactional
    @Override
    public void delete(String id) {
        RatingId ratingId = getRatingId(id);
        Rating existing = repository.findOne(ratingId);
        if(existing==null)
        {
            throw new RatingNotFoundException("Rating with movie: " + ratingId.getMovie().getTitle() + "and user: "+ ratingId.getUser().getEmail()  +" not found");
        }
        repository.delete(existing);
    }
    @Transactional
    @Override
    public boolean deleteByMovie(Movie movie) {
        List<Rating> existing = repository.findByMovie(movie);
        if(existing.size()==0) {
            return true;
        }
        if(repository.deleteByMovie(movie)>0)
        {
            return true;
        }
        return false;
    }
    @Transactional
    @Override
    public boolean deleteByUser(User user) {
        List<Rating> existing = repository.findByUser(user);
        if(existing.size()==0) {
            return true;
        }
        if(repository.deleteByUser(user)>0)
        {
            return true;
        }
        return false;
    }
}
