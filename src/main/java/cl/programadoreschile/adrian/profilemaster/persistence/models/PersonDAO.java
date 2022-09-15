package cl.programadoreschile.adrian.profilemaster.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "person")
@Getter
@Setter
public class PersonDAO {

    @Id
    @Column(name = "id_person")
    private String idPerson;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "last_name")
    @NonNull
    private String lastName;
    @Column(name = "date_of_birth")
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    @Column(name = "email")
    @NonNull
    @Email
    private String email;
    @Column(name = "address")
    @NonNull
    private String address;
    @Column(name = "city")
    @NonNull
    private String city;
    @Column(name = "country")
    @NonNull
    private String country;
    @Column(name = "change_of_address")
    private boolean changeOfAddress;

}
