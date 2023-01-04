package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.User;

import java.util.List;

public interface UserService {
    public Integer saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Integer user);

    public void deleteUser(Integer user);
}
