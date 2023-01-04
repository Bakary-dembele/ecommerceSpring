package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.User;
import com.bakary.ecommerce.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UsersRepository repository;

    @Override
    public Integer saveUser(User user) {
        return repository.save(user).getId();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Integer user) {
      return  repository.findById(user).get();
    }

    @Override
    public void deleteUser(Integer user) {

    }
}
