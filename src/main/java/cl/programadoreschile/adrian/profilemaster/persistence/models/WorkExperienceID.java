package cl.programadoreschile.adrian.profilemaster.persistence.models;

import java.io.Serializable;
import java.util.Objects;

public class WorkExperienceID implements Serializable {

    private String idPerson;
    private Integer idWorkExperience;

    public WorkExperienceID() {
    }

    public WorkExperienceID(String idPerson, Integer idWorkExperience) {
        this.idPerson = idPerson;
        this.idWorkExperience = idWorkExperience;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public WorkExperienceID setIdPerson(String idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public Integer getIdWorkExperience() {
        return idWorkExperience;
    }

    public WorkExperienceID setIdWorkExperience(Integer idWorkExperience) {
        this.idWorkExperience = idWorkExperience;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkExperienceID that)) return false;
        return Objects.equals(idWorkExperience, that.idWorkExperience) && idPerson.equals(that.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, idWorkExperience);
    }
}
