package com.Reto1.Reto1c5.app.repositories.crud;


import com.Reto1.Reto1c5.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marcela
 */

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    public Optional<User> findByName(String name);

    public List<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
