package cl.programadoreschile.adrian.profilemaster.validate;

import cl.programadoreschile.adrian.profilemaster.error.APIException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class ValidDateRangeValidator implements ConstraintValidator<ValidDateRange, Object> {

    private String startDateName;
    private String endDateName;

    @Override
    public void initialize(final ValidDateRange dates) {
        this.startDateName = dates.startDate();
        this.endDateName = dates.endDate();
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {
        try {
            final String startDate = BeanUtils.getProperty(value, startDateName);
            final String endDate = BeanUtils.getProperty(value, endDateName);
            final LocalDate localStartDate = LocalDate.parse(startDate);
            final LocalDate localEndDate = LocalDate.parse(endDate);
            return localStartDate.isBefore(localEndDate);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new APIException(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
