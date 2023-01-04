package com.bakary.ecommerce.controller;

import com.bakary.ecommerce.bo.User;
import com.bakary.ecommerce.exception.UserNotfoundException;
import com.bakary.ecommerce.repository.UsersRepository;
import com.bakary.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    LocalDate curDate = LocalDate.now();
    @Autowired
    private UserService userService;
    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/users/saveUser", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody User user) {
         user = userService.saveUser(user);
        return  new ResponseEntity<String>("User  " + user.getName() + " " + user.getLastname()+ " a bien crée", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> allUsers = userService.getAllUsers();

        //sort users
        Sort.TypedSort<User> user = Sort.sort(User.class);
        Sort sort = user.by(User::getLastname).ascending()
                .and(user.by(User::getLastname).descending());
        System.out.println("====sort===="+ sort);

        return  new ResponseEntity<List<User>>(allUsers,  HttpStatus.OK);
    }

    @GetMapping("/users/getUserById/{user}")
    public ResponseEntity<User> getUserById(@PathVariable("user") Integer user) {

        boolean isUserExist = userService.isUserExist(user);

        if (isUserExist) {
            User u = userService.getUserById(user);
            int birthYear = curDate.getYear() - u.getAge();
            System.out.println("====birthYear====" + birthYear);

            return new ResponseEntity<User>(u, HttpStatus.OK);
        } else {

            throw new UserNotfoundException();
        }

    }

    @PutMapping("/users/updateUser/{user}")
    public ResponseEntity<String> updateUser(@PathVariable("user") Integer user, @RequestBody User u) {

        boolean isUserExist = userService.isUserExist(user);

        if (isUserExist) {
            User userFromDb =  userService.getUserById(user);
            userFromDb.setName(u.getName());
            userFromDb.setLastname(u.getLastname());
            userFromDb.setAge(u.getAge());

            User us = userService.saveUser((userFromDb));
            return  new ResponseEntity<String>("User " + us.getName() + " " + us.getLastname() +" a bien été modifié", HttpStatus.OK);

        } else {
            throw  new UserNotfoundException();
        }

    }

    @DeleteMapping("/users/deleteUser/{user}")
        public ResponseEntity<String> deleteUser(@PathVariable ("user") Integer user){

        boolean isUserExist = userService.isUserExist(user);

        if(isUserExist) {
            userService.deleteUser(user);
            return  new ResponseEntity<String>("User a bien été supprimé", HttpStatus.OK);
        }else {
            throw  new UserNotfoundException();
        }
    }
}
