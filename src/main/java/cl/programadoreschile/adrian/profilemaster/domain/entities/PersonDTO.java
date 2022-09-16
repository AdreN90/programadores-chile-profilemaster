package cl.programadoreschile.adrian.profilemaster.domain.entities;

import cl.programadoreschile.adrian.profilemaster.validate.ValidDate;
import cl.programadoreschile.adrian.profilemaster.validate.ValidRut;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PersonDTO {

    @NotBlank(message = "idPerson must be not empty or null")
    @ValidRut(message = "idPerson invalid format, must be [0-9]-[K|k|0-9]")
    @Size(min = 1, max = 11, message = "idPerson size must be between {min} and {max}")
    private String idPerson;
    @NotBlank(message = "name must be not empty or null")
    @Size(min = 1, max = 50, message = "name size must be between {min} and {max}")
    private String name;
    @NotBlank(message = "lastName must be not empty or null")
    @Size(min = 1, max = 50, message = "lastName size must be between {min} and {max}")
    private String lastName;
    @NotBlank(message = "dateOfBirth must be not empty or null")
    @ValidDate(message = "dateOfBirth invalid format date, must be yyyy-MM-dd")
    private String dateOfBirth;
    @NotBlank(message = "email must be not empty or null")
    @Email(message = "email must be a well-formed email address")
    @Size(min = 1, max = 100, message = "email size must be between {min} and {max}")
    private String email;
    @NotBlank(message = "address must be not empty or null")
    @Size(min = 1, max = 150, message = "address size must be between {min} and {max}")
    private String address;
    @NotBlank(message = "city must be not empty or null")
    @Size(min = 1, max = 50, message = "city size must be between {min} and {max}")
    private String city;
    @NotBlank(message = "country must be not empty or null")
    @Size(min = 1, max = 50, message = "country size must be between {min} and {max}")
    private String country;
    @NotNull(message = "changeOfAddress must be not null")
    private boolean changeOfAddress;

}
