package movieflix.service;

import movieflix.entity.Movie;
import movieflix.exception.MovieAlreadyExistsException;
import movieflix.exception.MovieNotFoundException;
import movieflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
@Service
public class MovieService implements IMovieService {

    @Autowired
    MovieRepository repository;

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie findOne(String id) {
        Movie existing = repository.findOne(id);
        if(existing==null) {
            throw new MovieNotFoundException("Movie with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Movie create(Movie movie) {
        Movie existing = repository.findOne(movie.getImdbId());
        if(existing!=null)
        {
            throw new MovieAlreadyExistsException("Movie is already in use: " + movie.getImdbId());
        }
        return repository.create(movie);
    }

    @Override
    @Transactional
    public Movie update(String id, Movie movie) {
        Movie existing = repository.findOne(id);
        if(existing==null)
        {
            throw new MovieNotFoundException("Movie with id: " + id + " not found");
        }
        return repository.update(movie);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Movie existing = repository.findOne(id);
        if(existing==null)
        {
            throw new MovieNotFoundException("Movie with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
