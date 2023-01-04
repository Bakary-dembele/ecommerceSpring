package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.User;
import com.bakary.ecommerce.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UsersRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        User  user = optional.get();
      return  user;
    }

    @Override
    public Integer deleteUser(Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public boolean isUserExist(Integer id) {
        return userRepository.existsById(id);
    }
}
