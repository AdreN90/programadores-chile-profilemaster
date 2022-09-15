package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Technology {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    private String idPerson;
    private Integer idTechnology;
    @NotBlank(message = "technology must be not empty or null")
    private String technology;

}
