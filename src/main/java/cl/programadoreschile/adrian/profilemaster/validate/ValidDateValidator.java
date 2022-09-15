package cl.programadoreschile.adrian.profilemaster.validate;

import cl.programadoreschile.adrian.profilemaster.error.APIException;
import com.google.common.base.Strings;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidDateValidator implements ConstraintValidator<ValidDate, String> {

    private Boolean isOptional;

    @Override
    public void initialize(ValidDate validDate) {
        this.isOptional = validDate.optional();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean validDate = isValidFormat("yyyy-MM-dd", value);
        return Boolean.TRUE.equals(isOptional) ? (validDate || (Strings.isNullOrEmpty(value))) : validDate;
    }

    private static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (value != null) {
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            }

        } catch (ParseException ex) {
            throw new APIException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return date != null;
    }
}
