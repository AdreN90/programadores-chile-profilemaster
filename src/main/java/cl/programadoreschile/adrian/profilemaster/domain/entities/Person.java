package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidDate;
import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Person {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    private String idPerson;
    @NotBlank(message = "name must be not empty or null")
    private String name;
    @NotBlank(message = "lastName must be not empty or null")
    private String lastName;
    @NotBlank(message = "dateOfBirth must be not empty or null")
    @ValidDate(message = "dateOfBirth invalid format date, must be yyyy-MM-dd")
    private String dateOfBirth;
    @NotBlank(message = "email must be not empty or null")
    @Email(message = "email must be a well-formed email address")
    private String email;
    @NotBlank(message = "address must be not empty or null")
    private String address;
    @NotBlank(message = "city must be not empty or null")
    private String city;
    @NotBlank(message = "country must be not empty or null")
    private String country;
    @NotNull(message = "changeOfAddress must be not null")
    private boolean changeOfAddress;

}
