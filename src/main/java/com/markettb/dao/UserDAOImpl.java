package com.markettb.dao;

import com.markettb.model.User;
import com.markettb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*GET User by Name*/
    @Override
    public Optional<User> getUserByName(String name) {
        return this.userRepository.findByName(name);
    }
}
