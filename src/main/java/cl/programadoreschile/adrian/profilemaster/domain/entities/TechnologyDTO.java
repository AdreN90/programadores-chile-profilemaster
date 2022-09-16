package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TechnologyDTO {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    @Size(min = 1, max = 11, message = "idPerson size must be between {min} and {max}")
    private String idPerson;
    private Integer idTechnology;
    @NotBlank(message = "technology must be not empty or null")
    @Size(min = 1, max = 50, message = "technology size must be between {min} and {max}")
    private String technology;

}
