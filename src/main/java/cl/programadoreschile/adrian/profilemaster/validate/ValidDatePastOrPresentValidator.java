package cl.programadoreschile.adrian.profilemaster.validate;

import com.google.common.base.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidDatePastOrPresentValidator implements ConstraintValidator<ValidDatePastOrPresent, String> {

    private Boolean isOptional;

    @Override
    public void initialize(ValidDatePastOrPresent validDate) {
        this.isOptional = validDate.optional();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean validDate = isValidDate(value);
        return Boolean.TRUE.equals(isOptional) ? (validDate || (Strings.isNullOrEmpty(value))) : validDate;
    }

    private static boolean isValidDate(String value) {
        final LocalDate localDate = LocalDate.parse(value);
        final LocalDate localDateNow = LocalDate.now();
        return localDate.isBefore(localDateNow) || localDate.isEqual(localDateNow);
    }
}
