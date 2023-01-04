package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.Contact;
import com.bakary.ecommerce.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Long saveContact(Contact contact) {
        return (long) contactRepository.save(contact).getId();
    }

    @Override
    public List<Contact> getContactContacts() {
        return null;
    }

    @Override
    public Contact getContactById(Integer contact) {
        return  contactRepository.findById(Long.valueOf(contact)).get();
    }

    @Override
    public void deleteContactById(Integer contact) {
    }
}
