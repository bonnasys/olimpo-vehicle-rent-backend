package br.com.bonnasys.olimpo.users.app.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private static final String MESSAGE_PATTERN = "(dd) ddddd-dddd";
    private static final String PHONE_REGEX = "\\((\\d{2})\\) (\\d{4,5})-(\\d{4})";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        ((ConstraintValidatorContextImpl) constraintValidatorContext)
                .addMessageParameter("phoneValidation", MESSAGE_PATTERN);
        if (phone == null) return false;
        Matcher matcher = PHONE_PATTERN.matcher(phone);
        return matcher.find();
    }
}