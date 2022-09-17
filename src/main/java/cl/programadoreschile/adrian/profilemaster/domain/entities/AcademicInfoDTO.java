package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidDate;
import cl.programadoreschile.adrian.profilemaster.validate.ValidDateRange;
import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ValidDateRange.List({@ValidDateRange(startDate = "startDate", endDate = "endDate")})
public class AcademicInfoDTO {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    @Size(min = 1, max = 11, message = "idPerson size must be between {min} and {max}")
    private String idPerson;
    private Integer idAcademicInfo;
    @ValidDate(message = "startDate invalid format date, must be yyyy-MM-dd")
    private String startDate;
    @ValidDate(message = "endDate invalid format date, must be yyyy-MM-dd")
    private String endDate;
    @NotBlank(message = "typeEducation must be not empty or null")
    @Pattern(regexp = "undergraduate|graduate|master|doctorate",
            message = "for typeEducation the possible values are: undergraduate, graduate, master, doctorate")
    private String typeEducation;
    @NotBlank(message = "educationalInstitution must be not empty or null")
    @Size(min = 1, max = 100, message = "educationalInstitution size must be between {min} and {max}")
    private String educationalInstitution;

}
