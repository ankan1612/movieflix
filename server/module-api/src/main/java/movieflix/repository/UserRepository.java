package movieflix.repository;

import movieflix.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
@Repository
public class UserRepository implements IUserRepository{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll",User.class);
        return  query.getResultList();
    }

    @Override
    public User findOne(String id) {
        return em.find(User.class, id);
    }

    @Override
    public User findByEmail(String email) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail",User.class);
        query.setParameter("pEmail",email);
        List<User> users =  query.getResultList();
        if(users!=null && users.size()==1)
        {
            return users.get(0);
        }
        return null;
    }

    @Override
    public Boolean findByEmailPassword(String email, String password) {
        TypedQuery<User> query = em.createNamedQuery("User.findByEmail",User.class);
        query.setParameter("pEmail",email);
        List<User> users =  query.getResultList();
        if(users!=null && users.size()==1)
        {
            return passwordEncoder.matches(password, users.get(0).getPassword());
        }
        return false;
    }

    @Override
    public List<User> findByRole(String role) {
        TypedQuery<User> query = em.createNamedQuery("User.findByRole",User.class);
        query.setParameter("pRole",role);
        return query.getResultList();
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        em.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }
}
