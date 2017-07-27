package movieflix.repository;

import movieflix.entity.Language;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/27/2017.
 */
@Repository
public class LanguageRepository implements ILanguageRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Language> findAll() {
        TypedQuery<Language> query = em.createNamedQuery("Language.findAll",Language.class);
        return  query.getResultList();
    }

    @Override
    public Language findOne(String id) {
        return em.find(Language.class, id);
    }

    @Override
    public Language findByName(String name) {
        TypedQuery<Language> query = em.createNamedQuery("Language.findByName",Language.class);
        query.setParameter("pName",name);
        List<Language> languages =  query.getResultList();
        if(languages!=null && languages.size()==1)
        {
            return languages.get(0);
        }
        return null;
    }

    @Override
    public Language create(Language language) {
        em.persist(language);
        return language;
    }

    @Override
    public Language update(Language language) {
        return em.merge(language);
    }

    @Override
    public void delete(Language language) {
        em.remove(language);
    }
}
