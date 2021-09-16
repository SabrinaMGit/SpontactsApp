package cityact.app.chat.services;

import cityact.app.chat.model.User;
import cityact.app.chat.model.UserInfo;

import java.util.List;

public interface UserService {
	User searchForUserByUsername(String username);
	void createNewUser(UserInfo userInfo, String password);
	User searchForUserByUserId(Integer userId);
	List<User> searchForUsersMatchingString(String str);
	User updateProfileImage(String username, byte[] newImagePath);
}
