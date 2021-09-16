package cityact.app.chat.services;

import cityact.app.chat.advices.LogMethodInfo;
import cityact.app.chat.database.UsersRepository;
import cityact.app.chat.model.User;
import cityact.app.chat.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UsersRepository userRepo;

	@LogMethodInfo
	@Override
	@Transactional
	public User searchForUserByUsername(String username) {
		return (User) userRepo.findUserByUsername(username);
	}

	@LogMethodInfo
	@Override
	@Transactional
	public void createNewUser(UserInfo userInfo, String password) {
		User user = new User(userInfo.getUsername(), password, userInfo.getEmail());
        userRepo.save(user);
	}

	@LogMethodInfo
	@Override
	@Transactional
	public User searchForUserByUserId(Integer userId) {
		return (User) userRepo.findUserById(userId);
	}

	@LogMethodInfo
	@Override
	@Transactional
	public List<User> searchForUsersMatchingString(String str) {
		return (List<User>) userRepo.findByUsernameIgnoreCaseStartingWith(str);
	}

	@LogMethodInfo
	@Override
	@Transactional
	public User updateProfileImage(String username, byte[] newImagePath) {
		User user = searchForUserByUsername(username);
		if (user != null) {
			user.setImage(newImagePath);
			userRepo.save(user);
		}
		return user;
	}

}
