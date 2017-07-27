package movieflix.repository;

import movieflix.entity.Language;

import java.util.List;

/**
 * Created by Ankan on 7/27/2017.
 */
public interface ILanguageRepository {
    public List<Language> findAll();
    public Language findOne(String id);
    public Language findByName(String name);
    public  Language create(Language language);
    public  Language update(Language language);
    public void  delete(Language language);
}
