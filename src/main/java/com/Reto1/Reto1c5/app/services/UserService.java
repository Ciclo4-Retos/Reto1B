package com.Reto1.Reto1c5.app.services;

import com.Reto1.Reto1c5.app.model.User;
import com.Reto1.Reto1c5.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Marcela
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }

    /**
     *
     * @param user
     * @return
     */

    public User save(User user) {
        if (user.getId() == null) {
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if (existUsers.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            Optional<User> existUser = repository.getUserById(user.getId());
            if (existUser.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        }
    }

    /**
     *
     * @param email
     * @return
     */

        public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()){
            return user.get();
        }else {
            return new User(null, email, password, "NO DEFINIDO");
        }
    }
}
