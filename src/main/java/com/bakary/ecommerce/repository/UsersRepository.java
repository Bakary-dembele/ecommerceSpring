package com.bakary.ecommerce.repository;

import com.bakary.ecommerce.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Integer> {
}
