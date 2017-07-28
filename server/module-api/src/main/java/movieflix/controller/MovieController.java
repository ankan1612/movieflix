package movieflix.controller;

import movieflix.entity.Movie;
import movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
@RestController
@RequestMapping(path = "movies")
public class MovieController {

    @Autowired
    MovieService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> findAll()
    {
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie create(@RequestBody Movie movie)
    {
        return service.create(movie);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie update(@PathVariable("id") String id, @RequestBody Movie movie)
    {
        return service.update(id, movie);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}
