package movieflix.service;

import movieflix.entity.Writer;
import movieflix.exception.WriterNotFoundException;
import movieflix.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/25/2017.
 */
@Service
public class WriterService implements IWriterService {

    @Autowired
    WriterRepository repository;

    @Override
    public List<Writer> findAll() {
        return repository.findAll();
    }

    @Override
    public Writer findOne(String id) {
        Writer existing = repository.findOne(id);
        if(existing==null) {
            throw new WriterNotFoundException("Writer with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Writer create(Writer writer) {
        return repository.create(writer);
    }

    @Override
    @Transactional
    public Writer update(String id, Writer writer) {
        Writer existing = repository.findOne(id);
        if(existing==null)
        {
            throw new WriterNotFoundException("Writer with id: " + id + " not found");
        }
        return repository.update(writer);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Writer existing = repository.findOne(id);
        if(existing==null)
        {
            throw new WriterNotFoundException("Writer with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
