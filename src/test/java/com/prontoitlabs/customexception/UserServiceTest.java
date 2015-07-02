package com.prontoitlabs.customexception;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prontoitlabs.customexception.domain.User;
import com.prontoitlabs.customexception.domain.enums.Gender;
import com.prontoitlabs.customexception.exception.UserNotFoundException;
import com.prontoitlabs.customexception.service.UserService;

public class UserServiceTest extends CustomexceptionApplicationTests {
    /**
     * @author Giridhar
     **/

    @Autowired
    private UserService userService;

    @Test
    public void shouldBeAbleToSignupUser() {
        User user = new User();
        user.setFirstName("Giridhar");
        user.setLastName("Kumar");
        user.setEmail("giridhar.lbsim@gmail.com");
        user.setGender(Gender.MALE);
        User savedUser = userService.save(user);
        Assert.assertNotNull(savedUser);
        Assert.assertTrue(savedUser.getFirstName().equalsIgnoreCase("Giridhar"));
    }

    @Test
    public void shouldBeAbleToFindUserByEmail() throws UserNotFoundException {
        User user = new User();
        user.setFirstName("Giridhar");
        user.setLastName("Kumar");
        user.setEmail("giridhar.lbsim@gmail.com");
        user.setGender(Gender.MALE);
        User savedUser = userService.save(user);

        User fetchedUser = userService.findByEmailId(savedUser.getEmail());
        Assert.assertNotNull(fetchedUser);
        Assert.assertEquals("", "Giridhar", fetchedUser.getFirstName());

    }

    @Test(expected = UserNotFoundException.class)
    public void shouldThrowUserNotFoundException() throws UserNotFoundException {
        userService.findByEmailId("abc@gmail.com");

    }
}
