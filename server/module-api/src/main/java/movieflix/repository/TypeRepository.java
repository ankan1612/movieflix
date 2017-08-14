package movieflix.repository;

import movieflix.entity.Actor;
import movieflix.entity.Type;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 8/13/2017.
 */
@Repository
public class TypeRepository implements ITypeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Type> findAll() {
        TypedQuery<Type> query = em.createNamedQuery("Type.findAll",Type.class);
        return  query.getResultList();
    }

    @Override
    public Type findOne(String id) {
        return em.find(Type.class, id);
    }

    @Override
    public Type findByName(String name) {
        TypedQuery<Type> query = em.createNamedQuery("Type.findByName",Type.class);
        query.setParameter("pName",name);
        List<Type> types =  query.getResultList();
        if(types!=null && types.size()==1)
        {
            return types.get(0);
        }
        return null;
    }

    @Override
    public Type create(Type type) {
        em.persist(type);
        return type;
    }

    @Override
    public Type update(Type type) {
        return em.merge(type);
    }

    @Override
    public void delete(Type type) {
        em.remove(type);
    }
}
