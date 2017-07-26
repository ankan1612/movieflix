package movieflix.repository;

import movieflix.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
@Repository
public class CountryRepository implements  ICountryRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Country> findAll() {
        TypedQuery<Country> query = em.createNamedQuery("Country.findAll",Country.class);
        return  query.getResultList();
    }

    @Override
    public Country findOne(String id) {
        return em.find(Country.class, id);
    }

    @Override
    public Country findByName(String name) {
        TypedQuery<Country> query = em.createNamedQuery("Country.findByName",Country.class);
        query.setParameter("pName",name);
        List<Country> countries =  query.getResultList();
        if(countries!=null && countries.size()==1)
        {
            return countries.get(0);
        }
        return null;
    }

    @Override
    public Country create(Country country) {
        em.persist(country);
        return country;
    }

    @Override
    public Country update(Country country) {
        return em.merge(country);
    }

    @Override
    public void delete(Country country) {
        em.remove(country);
    }
}
