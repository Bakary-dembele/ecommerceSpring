package com.bakary.ecommerce.service;

import com.bakary.ecommerce.bo.Contact;

import java.util.List;

public interface ContactService {
     public Long saveContact(Contact contact);
     public List<Contact> getContactContacts();
     public Contact getContactById(Integer contact);
     public void deleteContactById(Integer contact);

}
