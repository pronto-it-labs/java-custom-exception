package com.prontoitlabs.customexception;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prontoitlabs.customexception.CustomexceptionApplication;
import com.prontoitlabs.customexception.service.DatabaseAdministrativeService;
import com.prontoitlabs.customexception.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CustomexceptionApplication.class)
@WebAppConfiguration
@EnableMongoAuditing
@ActiveProfiles("test")
public class CustomexceptionApplicationTests {

  @Autowired
  private DatabaseAdministrativeService databaseAdministrativeService;

  @Autowired
  private UserService userService;

  @Test
  public void contextLoads() {}

  @After
  public void tearDown() {
    databaseAdministrativeService.deleteAll();
  }
}
