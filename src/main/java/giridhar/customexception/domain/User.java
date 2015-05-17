package giridhar.customexception.domain;

import giridhar.customexception.domain.enums.Gender;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author giridhar
 *
 */
@Document
@JsonIgnoreProperties
public class User extends AbstractMongoEntity {

  private static final long serialVersionUID = 6911235644079473406L;

  private String firstName;

  private String lastName;

  private Gender gender;

  @Indexed(unique = true)
  private String email;

  private String password;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
