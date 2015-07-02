package com.prontoitlabs.customexception.service;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.exception.UserNotFoundException;

public interface UserService {

    User save(User user);

    User findByEmailId(String emailId) throws UserNotFoundException;
}
