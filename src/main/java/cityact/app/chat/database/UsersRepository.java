package cityact.app.chat.database;

import cityact.app.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User,Integer> {

  User findUserByUsername(String username);
  User findUserById(Integer id);
  List<User> findByUsernameIgnoreCaseStartingWith(String str);
}
