package movieflix.controller;

import movieflix.entity.Genre;
import movieflix.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
@RestController
@RequestMapping(path = "genres")
public class GenreController {

    @Autowired
    GenreService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> findAll()
    {
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Genre findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Genre create(@RequestBody Genre genre)
    {
        return service.create(genre);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Genre update(@PathVariable("id") String id, @RequestBody Genre genre)
    {
        return service.update(id, genre);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}

