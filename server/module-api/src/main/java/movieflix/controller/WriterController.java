package movieflix.controller;

import movieflix.entity.Writer;
import movieflix.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@RestController
@RequestMapping(path = "writers")
public class WriterController {
    @Autowired
    WriterService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Writer> findAll()
    {
        return service.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Writer findOne(@PathVariable("id") String id)
    {
        return service.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Writer create(@RequestBody Writer writer)
    {
        return service.create(writer);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Writer update(@PathVariable("id") String id, @RequestBody Writer writer)
    {
        return service.update(id, writer);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public void delete(@PathVariable("id") String id)
    {
        service.delete(id);
    }
}
