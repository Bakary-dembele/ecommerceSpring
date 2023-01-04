package com.bakary.ecommerce.controller;

import com.bakary.ecommerce.bo.Contact;
import com.bakary.ecommerce.bo.User;
import com.bakary.ecommerce.repository.ContactRepository;
import com.bakary.ecommerce.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/contacts/save")
    public ResponseEntity<String> saveContact(@RequestBody Contact contact) {
        Long id = contactService.saveContact(contact);
        return  new ResponseEntity<String>("User avec " + id + " a bien crée", HttpStatus.OK);
    }
    @GetMapping("contacts/{id}")
    public  ResponseEntity<Contact> getUserById(@PathVariable("id") Integer contact ) {
        Contact u = contactService.getContactById(contact);
          return new ResponseEntity<Contact>(u, HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllUserDetails() {
        List<Contact> allUsers = (List<Contact>) contactRepository.findAll();
        return new ResponseEntity<>(allUsers,  HttpStatus.OK);
    }



}
