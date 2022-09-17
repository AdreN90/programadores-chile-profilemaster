package cl.programadoreschile.adrian.profilemaster.persistence.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "academic_info")
@IdClass(AcademicInfoID.class)
public class AcademicInfoDAO {

    @Id
    @Column(name = "id_person")
    private String idPerson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_academic_info")
    private Integer idAcademicInfo;

    @Column(name = "start_date")
    @NonNull
    private String startDate;

    @Column(name = "end_date")
    @NonNull
    private String endDate;

    @Column(name = "type_education")
    @NonNull
    private String typeEducation;

    @Column(name = "educational_institution")
    @NonNull
    private String educationalInstitution;

}
