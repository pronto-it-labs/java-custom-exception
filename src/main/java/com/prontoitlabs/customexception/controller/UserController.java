package com.prontoitlabs.customexception.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.exception.UserNotFoundException;
import com.prontoitlabs.customexception.service.UserService;
import com.prontoitlabs.customexception.util.RestResponse;


@Controller
@RequestMapping(value = "/user")
public class UserController {

  private static final Logger LOGGER = Logger.getLogger("UserController");
  @Autowired
  private UserService userService;

  @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<RestResponse> signupUser(@RequestBody User user) {
    LOGGER.info("user to save is: "+user);
    return new ResponseEntity<RestResponse>(new RestResponse(Boolean.TRUE, "Succesfully Signed Up!", userService.save(user)), HttpStatus.OK);
  }

  @RequestMapping(value = "/findby-email", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<RestResponse> findByEMail(@RequestParam String email) throws UserNotFoundException {
    LOGGER.info("User id to find is: "+email);
    return new ResponseEntity<RestResponse>(new RestResponse(Boolean.TRUE, "Succesfully Logged In!", userService.findByEmailId(email)), HttpStatus.OK);
  }
}
