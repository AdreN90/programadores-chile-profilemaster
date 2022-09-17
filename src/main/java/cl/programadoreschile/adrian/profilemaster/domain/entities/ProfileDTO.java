package cl.programadoreschile.adrian.profilemaster.domain.entities;

public class ProfileDTO {

    private PersonDTO person;
    private AdditionalInfoDTO additionalInfo;
    private TechnologyDTO technology;
    private WorkExperienceDTO workExperience;
    private AcademicInfoDTO academicInfo;

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

    public TechnologyDTO getTechnology() {
        return technology;
    }

    public ProfileDTO setTechnology(TechnologyDTO technology) {
        this.technology = technology;
        return this;
    }

    public WorkExperienceDTO getWorkExperience() {
        return workExperience;
    }

    public ProfileDTO setWorkExperience(WorkExperienceDTO workExperience) {
        this.workExperience = workExperience;
        return this;
    }

    public AcademicInfoDTO getAcademicInfo() {
        return academicInfo;
    }

    public ProfileDTO setAcademicInfo(AcademicInfoDTO academicInfo) {
        this.academicInfo = academicInfo;
        return this;
    }
}
