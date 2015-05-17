package giridhar.customexception.repository;

import giridhar.customexception.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author giridhar
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
  
  User findByEmail(String email);

}
