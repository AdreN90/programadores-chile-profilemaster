package cl.programadoreschile.adrian.profilemaster.persistence.models;

import java.io.Serializable;
import java.util.Objects;

public class TechnologyId implements Serializable {

    private String idPerson;
    private Integer idTechnology;

    public TechnologyId() {
    }

    public TechnologyId(String idPerson, Integer idTechnology) {
        this.idPerson = idPerson;
        this.idTechnology = idTechnology;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public TechnologyId setIdPerson(String idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    public long getIdTechnology() {
        return idTechnology;
    }

    public TechnologyId setIdTechnology(Integer idTechnology) {
        this.idTechnology = idTechnology;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnologyId that)) return false;
        return idTechnology == that.idTechnology && idPerson.equals(that.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, idTechnology);
    }
}
