package cityact.app.chat.services.validation;

import cityact.app.chat.model.User;
import cityact.app.chat.model.UserInfo;
import cityact.app.chat.model.Validatable;
import cityact.app.chat.services.UserService;
import cityact.app.chat.utils.SystemMessages;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthValidator implements ValidationService {

	@Autowired
    private UserService userService;

	@Override
	public boolean validate(Validatable object, Object... extraInfo) {
		if (object == null) {
			if (extraInfo != null) {
			  String username = ((String) extraInfo[0]);
			  User user = userService.searchForUserByUsername(username);
			  return user != null;
			}
			return false;
		}
		UserInfo userInfo = ((UserInfo) object);
		User user = userService.searchForUserByUsername(userInfo.getUsername());
		return user != null;
	}

	@Override
	public String getErrorMessage() {
		return SystemMessages.USER_NOT_EXIST;
	}

	@Override
	public ValidationTypes getType() {
		return ValidationTypes.USER_EXISTENCE;
	}
}
