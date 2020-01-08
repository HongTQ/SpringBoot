package simple.security.boot.spring.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import simple.security.boot.spring.app.entity.User;
import simple.security.boot.spring.app.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		if (user.getUserName().length() < 6 || user.getUserName().length() > 45) {
			errors.reject("userName", "Size.userForm.name");
		}
		if (userService.findByUserName(user.getUserName()) != null) {
			errors.reject("userName", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmpty(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 60) {
			errors.rejectValue("password", "Size.userForm.password");
		}
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
