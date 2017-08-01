package movieflix.service;

import movieflix.entity.User;
import movieflix.exception.UserAlreadyExistsException;
import movieflix.exception.UserNotFoundException;
import movieflix.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ankan on 7/24/2017.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository repository;

    @Autowired
    IRatingService ratingService;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOne(String id) {
        User existing = repository.findOne(id);
        if(existing==null) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
        return existing;
    }

    @Override
    public List<User> findByRole(String role) {
        List<User> existing = repository.findByRole(role);
        if(existing==null) {
            throw new UserNotFoundException("User with role: " + role + " not found");
        }
        return existing;
    }

    @Override
    @Transactional
    public User create(User user) {
        User existing = repository.findByEmail(user.getEmail());
        if(existing!=null)
        {
            throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
        }
        return repository.create(user);
    }

    @Override
    @Transactional
    public User update(String id, User user) {
        User existing = repository.findOne(id);
        if(existing==null)
        {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
        return repository.update(user);
    }

    @Override
    @Transactional
    public void delete(String id) {
        User existing = repository.findOne(id);
        if(existing==null)
        {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
        if(ratingService.deleteByUser(existing)) {
            repository.delete(existing);
        }
    }
}
