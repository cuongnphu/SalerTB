package com.markettb.dao;

import com.markettb.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> getUserByName(String name);
}
