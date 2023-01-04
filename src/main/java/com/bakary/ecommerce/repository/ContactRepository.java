package com.bakary.ecommerce.repository;

import com.bakary.ecommerce.bo.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}