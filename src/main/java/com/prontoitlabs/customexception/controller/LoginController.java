package com.prontoitlabs.customexception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prontoitlabs.customexception.dto.LoginDto;
import com.prontoitlabs.customexception.exception.UserNotFoundException;
import com.prontoitlabs.customexception.service.LoginService;
import com.prontoitlabs.customexception.util.RestResponse;

/**
 * @version 1.0, 01-Jul-2015
 * @author giridhar
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = { "/" }, method = RequestMethod.POST)
    private ResponseEntity<RestResponse> login(@RequestBody LoginDto loginDto) throws UserNotFoundException {
        return new ResponseEntity<RestResponse>(new RestResponse(Boolean.TRUE, "Logged in successfully", loginService.login(loginDto)), HttpStatus.OK);
    }

}
