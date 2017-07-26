package movieflix.repository;

import movieflix.entity.Country;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface ICountryRepository {
    public List<Country> findAll();
    public Country findOne(String id);
    public Country findByName(String name);
    public  Country create(Country country);
    public  Country update(Country country);
    public void  delete(Country country);
}
