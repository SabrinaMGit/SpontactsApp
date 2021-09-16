package cityact.app.chat.services.validation;

import cityact.app.chat.model.Validatable;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;

public interface ValidationService {

	boolean validate(Validatable object, Object... extraInfo);
	String getErrorMessage();
    ValidationTypes getType();
}
