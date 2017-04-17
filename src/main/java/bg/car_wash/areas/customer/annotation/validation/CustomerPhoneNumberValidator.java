package bg.car_wash.areas.customer.annotation.validation;

import bg.car_wash.areas.customer.annotation.ValidCustomerPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerPhoneNumberValidator implements ConstraintValidator<ValidCustomerPhoneNumber, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String PHONE_NUMBER_PATTERN = "^(\\+{0,1}[0-9]{1,3}\\s{0,1}[0-9]{3}\\s{0,1}[0-9]{3}\\s{0,1}[0-9]{3})$";

	@Override
	public void initialize(ValidCustomerPhoneNumber validCustomerPhoneNumber) {

	}

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context){
		return (validatePhoneNumber(phoneNumber));
	}
	private boolean validatePhoneNumber(String email) {
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}