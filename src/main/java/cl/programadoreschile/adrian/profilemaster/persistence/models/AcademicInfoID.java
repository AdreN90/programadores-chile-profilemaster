package cl.programadoreschile.adrian.profilemaster.persistence.models;

import java.io.Serializable;
import java.util.Objects;

public class AcademicInfoID implements Serializable {

    private String idPerson;
    private Integer idAcademicInfo;

    public AcademicInfoID() {
    }

    public AcademicInfoID(String idPerson, Integer idAcademicInfo) {
        this.idPerson = idPerson;
        this.idAcademicInfo = idAcademicInfo;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public AcademicInfoID setIdPerson(String idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public Integer getIdAcademicInfo() {
        return idAcademicInfo;
    }

    public AcademicInfoID setIdAcademicInfo(Integer idAcademicInfo) {
        this.idAcademicInfo = idAcademicInfo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AcademicInfoID that)) return false;
        return Objects.equals(idAcademicInfo, that.idAcademicInfo) && idPerson.equals(that.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, idAcademicInfo);
    }
}
