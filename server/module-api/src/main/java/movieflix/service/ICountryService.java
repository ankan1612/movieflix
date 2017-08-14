package movieflix.service;

import movieflix.entity.Country;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface ICountryService {
     List<Country> findAll();
     Country findOne(String id);
     Country findByName(String name);

    Country checkByName(String name);

    Country create(Country country);
      Country update(String id, Country country);
     void  delete(String id);
}
