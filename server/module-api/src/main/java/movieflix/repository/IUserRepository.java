package movieflix.repository;

import movieflix.entity.User;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
public interface IUserRepository {
     List<User> findAll();
      User findOne(String id);
      User findByEmail(String email);
    Boolean findByEmailPassword(String email, String password);

    User authenticateUser(String email, String password);

    List<User> findByRole(String role);
      User create(User emp);
      User update(User emp);
     void  delete(User emp);
}
