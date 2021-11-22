package com.Reto1.Reto1c5.app.repositories;

import com.Reto1.Reto1c5.app.model.User;
import com.Reto1.Reto1c5.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marcela
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    public Optional<User> getUserByName(String name){
        return repository.findByName(name);

    }

    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);

    }

    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);

    }
    public Optional<User> getUserByEmailAndPassword (String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }

    public User save(User user){
        return repository.save(user);
    }
}
