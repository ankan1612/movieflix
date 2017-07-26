package movieflix.service;

import movieflix.entity.Actor;
import movieflix.entity.Country;
import movieflix.entity.User;
import movieflix.exception.*;
import movieflix.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
@Service
public class CountryService implements  ICountryService{

    @Autowired
    CountryRepository repository;

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findOne(String id) {
        Country existing = repository.findOne(id);
        if(existing==null) {
            throw new CountryNotFoundException("Country with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public Country create(Country country) {
        Country existing = repository.findByName(country.getName());
        if(existing!=null)
        {
            throw new CountryAlreadyExistsException("Country is already in use: " + country.getName());
        }
        return repository.create(country);
    }

    @Override
    @Transactional
    public Country update(String id, Country country) {
        Country existing = repository.findOne(id);
        if(existing==null)
        {
            throw new CountryNotFoundException("Country with id: " + id + " not found");
        }
        return repository.update(country);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Country existing = repository.findOne(id);
        if(existing==null)
        {
            throw new CountryNotFoundException("Country with id: " + id + " not found");
        }
        repository.delete(existing);
    }
}
