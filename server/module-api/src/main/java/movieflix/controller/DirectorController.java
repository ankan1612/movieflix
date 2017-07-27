package movieflix.controller;

import movieflix.entity.Director;
import movieflix.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@RestController
@RequestMapping(path = "directors")
public class DirectorController {
    @Autowired
    DirectorService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Director> findAll()
    {
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Director findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Director create(@RequestBody Director director)
    {
        return service.create(director);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Director update(@PathVariable("id") String id, @RequestBody Director director)
    {
        return service.update(id, director);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}
