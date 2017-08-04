package movieflix.service;

import movieflix.entity.User;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
public interface IUserService {
     List<User> findAll();
     User findOne(String id);
    List<User> findByRole(String role);
    User findOneByEmailPassword(String email, String password);
    User create(User user);
      User update(String id, User user);
     void  delete(String id);
}
