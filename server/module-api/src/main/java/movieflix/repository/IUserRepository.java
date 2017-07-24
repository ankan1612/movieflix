package movieflix.repository;

import movieflix.entity.User;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
public interface IUserRepository {
    public List<User> findAll();
    public  User findOne(String id);
    public  User findByEmail(String email);
    public  User create(User emp);
    public  User update(User emp);
    public void  delete(User emp);
}
