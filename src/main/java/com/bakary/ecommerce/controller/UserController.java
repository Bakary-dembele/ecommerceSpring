package com.bakary.ecommerce.controller;

import com.bakary.ecommerce.bo.User;
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
    private UserService service;

    @RequestMapping("/users/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        Integer id = service.saveUser((user));
        return  new ResponseEntity<String>("User avec " + id + " a bien crée", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> allUsers = service.getAllUsers();
        System.out.println("====allUsers===="+ allUsers);

        //sort users
        Sort.TypedSort<User> user = Sort.sort(User.class);
        Sort sort = user.by(User::getLastname).ascending()
                .and(user.by(User::getLastname).descending());
        System.out.println("====sort===="+ sort);

        return  new ResponseEntity<List<User>>(allUsers,  HttpStatus.OK);
    }

    @GetMapping("/users/getUserById/{user}")
    public ResponseEntity<User> getUserById(@PathVariable("user") Integer user) {
        User u = service.getUserById(user);
        int birthYear = curDate.getYear() - u.getAge();

         System.out.println("====birthYear===="+ birthYear);

        return  new ResponseEntity<User>(u, HttpStatus.OK);
    }

    @PutMapping("/users/updateUser/{user}")
    public ResponseEntity<String> updateUser(@PathVariable("user") Integer user, @RequestBody User u) {
      User userFromDb =  service.getUserById(user);
      userFromDb.setName(u.getName());
      userFromDb.setLastname(u.getLastname());
      userFromDb.setAge(u.getAge());

      Integer id = service.saveUser((userFromDb));

      return  new ResponseEntity<String>("User avec " + id + " a bien été modifié", HttpStatus.OK);
    }

    @DeleteMapping("/users/deleteUser/{user}")
        public ResponseEntity<String> deleteUser(@PathVariable ("user") Integer user){
          service.deleteUser(user);
          return  new ResponseEntity<String>("User avec" + user + " a bien été modifié", HttpStatus.OK);
    }


}
