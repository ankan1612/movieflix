package movieflix.service;

import movieflix.entity.Genre;
import movieflix.exception.GenreAlreadyExistsException;
import movieflix.exception.CountryNotFoundException;
import movieflix.exception.GenreNotFoundException;
import movieflix.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
@Service
public class GenreService implements  IGenreService{

    @Autowired
    GenreRepository repository;

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }

    @Override
    public Genre findOne(String id) {
        Genre existing = repository.findOne(id);
        if(existing==null) {
            throw new CountryNotFoundException("Genre with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Genre create(Genre genre) {
        Genre existing = repository.findByName(genre.getName());
        if(existing!=null)
        {
            throw new GenreAlreadyExistsException("Genre is already in use: " + genre.getName());
        }
        return repository.create(genre);
    }

    @Override
    @Transactional
    public Genre update(String id, Genre genre) {
        Genre existing = repository.findOne(id);
        if(existing==null)
        {
            throw new GenreNotFoundException("Genre with id: " + id + " not found");
        }
        return repository.update(genre);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Genre existing = repository.findOne(id);
        if(existing==null)
        {
            throw new GenreNotFoundException("Genre with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
