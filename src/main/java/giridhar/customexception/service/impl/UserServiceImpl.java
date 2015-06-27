package giridhar.customexception.service.impl;

import giridhar.customexception.domain.User;
import giridhar.customexception.exception.UserNotFoundException;
import giridhar.customexception.repository.UserRepository;
import giridhar.customexception.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author giridhar
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*
     * This service will save user.
     */
    @Override
    public User save(User user) {
        validateUser(user);
        return userRepository.save(user);
    }

    private void validateUser(User user) {
        if ((user.getFirstName() == null)) {
            throw new IllegalArgumentException("Invalid User's First Name !");
        }

        if ((user.getLastName() == null)) {
            throw new IllegalArgumentException("Invalid User's Last Name !");
        }

        if (user.getGender() == null) {
            throw new IllegalArgumentException("Invalid User's Gender !");
        }
        if ((user.getEmail() == null)) {
            throw new IllegalArgumentException("Invalid User's Gender !");
        }

        if ((user.getEmail() == null)) {
            throw new IllegalArgumentException("Invalid User's Email !");
        }
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Invalid Password !");
        }
    }

    @Override
    public User findByEmailId(String emailId) throws UserNotFoundException {

        if ((emailId == null) || (emailId == "")) {
            throw new IllegalArgumentException("userId not found ");
        }
        User user = userRepository.findByEmail(emailId);
        if (user == null) {

            throw new UserNotFoundException();
        }

        return user;

    }

}
