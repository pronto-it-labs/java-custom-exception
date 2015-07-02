package com.prontoitlabs.customexception.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prontoitlabs.customexception.domain.User;

/**
 * @author giridhar
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
