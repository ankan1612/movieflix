package movieflix.service;

import movieflix.entity.Language;

import java.util.List;

/**
 * Created by Ankan on 7/26/2017.
 */
public interface ILanguageService {
     List<Language> findAll();
     Language findOne(String id);
    Language findByName(String name);

    Language checkByName(String name);

    Language create(Language language);
      Language update(String id, Language language);
     void  delete(String id);
}
