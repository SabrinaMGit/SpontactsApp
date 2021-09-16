package cityact.app.chat.services.validation;

import cityact.app.chat.model.Conversation;
import cityact.app.chat.model.User;
import cityact.app.chat.model.Validatable;
import cityact.app.chat.utils.SystemMessages;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;
import org.springframework.stereotype.Service;

@Service
public class OwnershipValidator implements ValidationService {
    @Override
    public boolean validate(Validatable object, Object... extraInfo) {
        if (extraInfo == null) return false;
        User user = ((User) object);
        Conversation conv = ((Conversation) extraInfo[0]);
        return user.getId().equals(conv.getOwnerId());
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public SystemMessages.ValidationTypes getType() {
        return ValidationTypes.CONVERSATION_OWNERSHIP;
    }
}
