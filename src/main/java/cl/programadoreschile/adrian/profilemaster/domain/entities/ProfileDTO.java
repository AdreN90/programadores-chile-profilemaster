package cl.programadoreschile.adrian.profilemaster.domain.entities;

import java.util.List;

public class ProfileDTO {

    private PersonDTO person;
    private AdditionalInfoDTO additionalInfo;
    private List<TechnologyDTO> technology;
    private List<WorkExperienceDTO> workExperience;
    private List<AcademicInfoDTO> academicInfo;

    public PersonDTO getPerson() {
        return person;
    }

    public ProfileDTO setPerson(PersonDTO person) {
        this.person = person;
        return this;
    }

    public AdditionalInfoDTO getAdditionalInfo() {
        return additionalInfo;
    }

    public ProfileDTO setAdditionalInfo(AdditionalInfoDTO additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public List<TechnologyDTO> getTechnology() {
        return technology;
    }

    public ProfileDTO setTechnology(List<TechnologyDTO> technology) {
        this.technology = technology;
        return this;
    }

    public List<WorkExperienceDTO> getWorkExperience() {
        return workExperience;
    }

    public ProfileDTO setWorkExperience(List<WorkExperienceDTO> workExperience) {
        this.workExperience = workExperience;
        return this;
    }

    public List<AcademicInfoDTO> getAcademicInfo() {
        return academicInfo;
    }

    public ProfileDTO setAcademicInfo(List<AcademicInfoDTO> academicInfo) {
        this.academicInfo = academicInfo;
        return this;
    }
}
