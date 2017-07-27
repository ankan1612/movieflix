package movieflix.service;

import movieflix.entity.Language;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface ILanguageService {
    public List<Language> findAll();
    public Language findOne(String id);
    public  Language create(Language language);
    public  Language update(String id, Language language);
    public void  delete(String id);
}
