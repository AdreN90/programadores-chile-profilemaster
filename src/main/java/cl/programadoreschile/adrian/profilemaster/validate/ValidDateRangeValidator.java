package cl.programadoreschile.adrian.profilemaster.validate;

import cl.programadoreschile.adrian.profilemaster.error.APIException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

import static cl.programadoreschile.adrian.profilemaster.util.APIUtils.castObject;
import static cl.programadoreschile.adrian.profilemaster.util.APIUtils.formatDoubleQuotes;

public class ValidDateRangeValidator implements ConstraintValidator<ValidDateRange, Object> {

    private String startDateName;
    private String endDateName;

    @Override
    public void initialize(final ValidDateRange dates) {
        this.startDateName = dates.startDate();
        this.endDateName = dates.endDate();
    }

    @Override
    public boolean isValid(final Object data, ConstraintValidatorContext context) {
        try {
            final JsonNode values = castObject(data, JsonNode.class);
            final String startDate = formatDoubleQuotes(values.findValue(startDateName).toString());
            final String endDate = formatDoubleQuotes(values.findValue(endDateName).toString());
            final LocalDate localStartDate = LocalDate.parse(startDate);
            final LocalDate localEndDate = LocalDate.parse(endDate);
            return localStartDate.isBefore(localEndDate);
        } catch (Exception ex) {
            throw new APIException(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
