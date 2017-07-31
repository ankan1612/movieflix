package movieflix.controller;

import movieflix.entity.Rating;
import movieflix.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ankan on 7/31/2017.
 */
@RestController
@RequestMapping(path = "ratings")
public class RatingController {
    @Autowired
    RatingService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Rating> findAll()
    {
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Rating findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Rating create(@RequestBody Rating rating)
    {
        return service.create(rating);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Rating update(@PathVariable("id") String id, @RequestBody Rating rating)
    {
        return service.update(id, rating);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}
