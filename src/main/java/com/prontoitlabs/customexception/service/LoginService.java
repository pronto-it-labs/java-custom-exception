package com.prontoitlabs.customexception.service;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.dto.LoginDto;
import com.prontoitlabs.customexception.exception.UserNotFoundException;

/**
 * @version 1.0, 01-Jul-2015
 * @author giridhar
 */
public interface LoginService {

    User login(LoginDto loginDto) throws UserNotFoundException;

}
