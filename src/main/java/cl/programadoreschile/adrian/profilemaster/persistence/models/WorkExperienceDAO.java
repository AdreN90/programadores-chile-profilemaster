package cl.programadoreschile.adrian.profilemaster.persistence.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "work_experience")
@IdClass(WorkExperienceID.class)
public class WorkExperienceDAO {

    @Id
    @Column(name = "id_person")
    private String idPerson;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_work_experience")
    private Integer idWorkExperience;

    @Column(name = "start_date")
    @NonNull
    private String startDate;

    @Column(name = "end_date")
    @NonNull
    private String endDate;

    @Column(name = "business")
    @NonNull
    private String business;

    @Column(name = "position")
    @NonNull
    private String position;

}
