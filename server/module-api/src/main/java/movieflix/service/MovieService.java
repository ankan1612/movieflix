package movieflix.service;

import movieflix.entity.*;
import movieflix.exception.MovieAlreadyExistsException;
import movieflix.exception.MovieNotFoundException;
import movieflix.repository.IActorRepository;
import movieflix.repository.ICountryRepository;
import movieflix.repository.ILanguageRepository;
import movieflix.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ankan on 7/24/2017.
 */
@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository repository;

    @Autowired
    IRatingService ratingService;

    @Autowired
    IGenreService genreService;

    @Autowired
    ILanguageService languageService;

    @Autowired
    ICountryService countryService;

    @Autowired
    IActorService actorService;

    @Autowired
    IDirectorService directorService;

    @Autowired
    IWriterService writerService;

    @Autowired
    ITypeService typeService;

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
    public List<Movie> findByTitle(String name) {
        List<Movie> existing = repository.findbyTitle(name);
        if(existing==null) {
            throw new MovieNotFoundException("Movie with title: " + name + " not found");
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
        Movie newMovie = checkConstraints(movie);
        return repository.create(newMovie);
    }

    public Movie checkConstraints(Movie movie)
    {
        Set<Genre> genres = movie.getGenre();
        Set<Genre> newGenres = new HashSet<>();
        for(Genre g: genres)
        {
            Genre genreByName = genreService.checkByName(g.getName());
            if(genreByName!=null)
            {
                newGenres.add(genreByName);
            }
            else
            {
                newGenres.add(g);
            }
        }
        Set<Language> languages = movie.getLanguage();
        Set<Language> newLanguages = new HashSet<>();
        for(Language l: languages)
        {
            Language langByName = languageService.checkByName(l.getName());
            if(langByName!=null)
            {
                newLanguages.add(langByName);
            }
            else
            {
                newLanguages.add(l);
            }
        }
        Set<Country> countries = movie.getCountry();
        Set<Country> newCountries = new HashSet<>();
        for(Country c: countries)
        {
            Country countryByName = countryService.checkByName(c.getName());
            if(countryByName!=null)
            {
                newCountries.add(countryByName);
            }
            else
            {
                newCountries.add(c);
            }
        }
        Set<Actor> actors = movie.getActor();
        Set<Actor> newActors = new HashSet<>();
        for(Actor a: actors)
        {
            Actor actorByName = actorService.checkByName(a.getName());
            if(actorByName!=null)
            {
                newActors.add(actorByName);
            }
            else
            {
                newActors.add(a);
            }
        }
        Set<Director> directors = movie.getDirector();
        Set<Director> newDirectors = new HashSet<>();
        for(Director d: directors)
        {
            Director directorByName = directorService.checkByName(d.getName());
            if(directorByName!=null)
            {
                newDirectors.add(directorByName);
            }
            else
            {
                newDirectors.add(d);
            }
        }
        Set<Writer> writers = movie.getWriter();
        Set<Writer> newWriters = new HashSet<>();
        for(Writer w: writers)
        {
            Writer writerByName = writerService.checkByName(w.getName());
            if(writerByName!=null)
            {
                newWriters.add(writerByName);
            }
            else
            {
                newWriters.add(w);
            }
        }
        Type type = movie.getType();
        Type typeByName = typeService.checkByName(type.getName());
        if(typeByName!=null)
        {
            movie.setType(typeByName);
        }
        movie.setGenre(newGenres);
        movie.setLanguage(newLanguages);
        movie.setCountry(newCountries);
        movie.setActor(newActors);
        movie.setDirector(newDirectors);
        movie.setWriter(newWriters);
        return movie;
    }

    @Override
    @Transactional
    public Movie update(String id, Movie movie) {
        Movie existing = repository.findOne(id);
        if(existing==null)
        {
            throw new MovieNotFoundException("Movie with id: " + id + " not found");
        }
        Movie newMovie = checkConstraints(movie);
        return repository.update(newMovie);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Movie existing = repository.findOne(id);
        if(existing==null)
        {
            throw new MovieNotFoundException("Movie with id: " + id + " not found");
        }
        if(ratingService.deleteByMovie(existing)) {
            repository.delete(existing);
        }
    }
}
