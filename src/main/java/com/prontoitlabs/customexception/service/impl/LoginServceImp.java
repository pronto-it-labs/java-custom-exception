/**
 *  Copyright 2015 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.prontoitlabs.customexception.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.dto.LoginDto;
import com.prontoitlabs.customexception.exception.UserNotFoundException;
import com.prontoitlabs.customexception.service.LoginService;
import com.prontoitlabs.customexception.service.UserService;

/**
 * @version 1.0, 01-Jul-2015
 * @author giridhar
 */
@Service
public class LoginServceImp implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public User login(LoginDto loginDto) throws UserNotFoundException {
        if (StringUtils.isEmpty(loginDto.getUserName()) && StringUtils.isEmpty(loginDto.getPassword())) {
            throw new IllegalArgumentException("Invalid User Name/Password");
        }
        User user = userService.findByEmailId(loginDto.getUserName());
        if (!(loginDto.getUserName().equalsIgnoreCase(user.getEmail()) && loginDto.getPassword().equalsIgnoreCase(user.getPassword()))) {
            throw new UserNotFoundException();
        }
        return userService.findByEmailId(loginDto.getUserName());
    }

}
