package giridhar.customexception.exception;


public class UserNotFoundException extends Exception {

  /**
   * @author Giridhar
   *
   **/
  private static final long serialVersionUID = -7986915990118714483L;

  private static final String DEFAULT_MESSAGE = "User not found!";

  public UserNotFoundException() {
    super(DEFAULT_MESSAGE);
  }

  public UserNotFoundException(String message) {
    super(message);
  }



}
