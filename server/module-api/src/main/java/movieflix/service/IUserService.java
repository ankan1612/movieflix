package movieflix.service;

import movieflix.entity.User;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
public interface IUserService {
    public List<User> findAll();
    public User findOne(String id);
    public  User create(User user);
    public  User update(String id, User user);
    public void  delete(String id);
}
