package cityact.app.chat.services.validation;

import cityact.app.chat.model.User;
import cityact.app.chat.model.Validatable;
import cityact.app.chat.utils.SystemMessages;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;
import org.springframework.stereotype.Service;

@Service
public class ConversationValidator implements ValidationService {

	@Override
	public boolean validate(Validatable object, Object... extraInfo) {
		if (extraInfo == null) return false;
		User user = ((User) object);
		String id = ((String) extraInfo[0]);
		return user.getConversations().stream().anyMatch(c -> c.getId().equals(Integer.parseInt(id)));
	}

	@Override
	public String getErrorMessage() {
		return SystemMessages.USER_NO_ACCESS;
	}

	@Override
	public ValidationTypes getType() {
		return ValidationTypes.CONVERSATION_MEMBERSHIP;
	}
}
