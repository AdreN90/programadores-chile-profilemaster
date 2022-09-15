package cl.programadoreschile.adrian.profilemaster.persistence.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "technology")
@IdClass(TechnologyId.class)
public class TechnologyDAO {

    @Id
    @Column(name = "id_person")
    private String idPerson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_technology")
    private Integer idTechnology;

    @Column(name = "technology")
    @NonNull
    private String technology;

}
