package movieflix.service;

import movieflix.entity.Language;
import movieflix.exception.CountryNotFoundException;
import movieflix.exception.LanguageAlreadyExistsException;
import movieflix.exception.LanguageNotFoundException;
import movieflix.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
@Service
public class LanguageService implements  ILanguageService{

    @Autowired
    LanguageRepository repository;

    @Override
    public List<Language> findAll() {
        return repository.findAll();
    }

    @Override
    public Language findOne(String id) {
        Language existing = repository.findOne(id);
        if(existing==null) {
            throw new CountryNotFoundException("Language with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    public Language findByName(String name) {
        Language existing = repository.findByName(name);
        if(existing==null) {
            throw new LanguageNotFoundException("Language with name: " + name + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Language create(Language language) {
        Language existing = repository.findByName(language.getName());
        if(existing!=null)
        {
            throw new LanguageAlreadyExistsException("Language is already in use: " + language.getName());
        }
        return repository.create(language);
    }

    @Override
    @Transactional
    public Language update(String id, Language language) {
        Language existing = repository.findOne(id);
        if(existing==null)
        {
            throw new LanguageNotFoundException("Language with id: " + id + " not found");
        }
        return repository.update(language);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Language existing = repository.findOne(id);
        if(existing==null)
        {
            throw new LanguageNotFoundException("Language with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
