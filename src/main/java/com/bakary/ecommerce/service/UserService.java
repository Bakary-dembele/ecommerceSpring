package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.User;

import java.util.List;

public interface UserService {
    public abstract User saveUser(User user);

    public abstract List<User> getAllUsers();

    public abstract User getUserById(Integer id);

    public abstract Integer deleteUser(Integer id);

    public abstract boolean isUserExist(Integer id);
}
