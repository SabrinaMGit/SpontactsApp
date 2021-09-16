package cityact.app.chat.services.validation;

import cityact.app.chat.advices.LogMethodInfo;
import cityact.app.chat.model.Validatable;
import cityact.app.chat.model.ValidationResponse;
import cityact.app.chat.utils.SystemMessages.ValidationTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationStrategy {

	private Map<ValidationTypes, ValidationService> validatorMap;

	@Autowired
	public ValidationStrategy(List<ValidationService> validators) {
		validatorMap = new HashMap<>();
		validators.forEach(validator -> validatorMap.put(validator.getType(), validator));
	}

	@LogMethodInfo
	public ValidationResponse provideValidation(ValidationTypes type, Validatable object, Object... extraInfo) {
		boolean result = true;
		String message = null;
		ValidationService validator = validatorMap.get(type);
		if (!validator.validate(object, extraInfo)) {
			result = false;
			message = validator.getErrorMessage();
		}
		return new ValidationResponse(result, message);
	}
}
