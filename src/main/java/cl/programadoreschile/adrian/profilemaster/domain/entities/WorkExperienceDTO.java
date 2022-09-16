package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidDate;
import cl.programadoreschile.adrian.profilemaster.validate.ValidDateRange;
import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ValidDateRange.List({@ValidDateRange(startDate = "startDate", endDate = "endDate")})
public class WorkExperienceDTO {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    @Size(min = 1, max = 11, message = "idPerson size must be between {min} and {max}")
    private String idPerson;
    private Integer idWorkExperience;
    @ValidDate(message = "startDate invalid format date, must be yyyy-MM-dd")
    private String startDate;
    @ValidDate(message = "endDate invalid format date, must be yyyy-MM-dd")
    private String endDate;
    @NotBlank(message = "business must be not empty or null")
    @Size(min = 1, max = 100, message = "business size must be between {min} and {max}")
    private String business;
    @NotBlank(message = "position must be not empty or null")
    @Size(min = 1, max = 100, message = "position size must be between {min} and {max}")
    private String position;

}
