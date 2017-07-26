package movieflix.service;

import movieflix.entity.Actor;
import movieflix.entity.Country;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface ICountryService {
    public List<Country> findAll();
    public Country findOne(String id);
    public  Country create(Country country);
    public  Country update(String id, Country country);
    public void  delete(String id);
}
