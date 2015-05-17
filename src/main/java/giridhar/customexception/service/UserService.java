package giridhar.customexception.service;


import giridhar.customexception.domain.User;
import giridhar.customexception.exception.UserNotFoundException;



public interface UserService {


  User save(User user);
  
  User findByEmailId(String emailId) throws UserNotFoundException;
}
