package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.*;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.ProfileGateway;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.YEARS;

@Repository
public class ProfileRepository implements ProfileGateway {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private WorkExperienceRepository workExperienceRepository;
    @Autowired
    private AcademicInfoRepository academicInfoRepository;

    @Override
    public List<ProfileDTO> getAll() {
        final List<PersonDTO> persons = personRepository.getAll();
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public Optional<ProfileDTO> getById(String id) {
        final Optional<PersonDTO> person = personRepository.getById(id);
        return person.map(this::setProfile);
    }

    @Override
    public List<ProfileDTO> getByCity(String city) {
        final List<PersonDTO> persons = personRepository.getByCity(city);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public List<ProfileDTO> getByCountry(String country) {
        final List<PersonDTO> persons = personRepository.getByCountry(country);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public List<ProfileDTO> getByChangeOfAddress(boolean changeOfAddress) {
        final List<PersonDTO> persons = personRepository.getByChangeOfAddress(changeOfAddress);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public List<ProfileDTO> getByTypeEducation(String typeEducation) {
        final List<AcademicInfoDTO> personListByEducation = academicInfoRepository.getByTypeEducation(typeEducation);
        return personListByEducation.stream().map(person -> getById(person.getIdPerson())
                        .orElseThrow(() -> new APIException("Person " + person.getIdPerson() + "not exist", HttpStatus.INTERNAL_SERVER_ERROR)))
                .toList();
    }

    @Override
    public List<ProfileDTO> getByTechnology(String technology) {
        final List<TechnologyDTO> personListByTechnology = technologyRepository.getByTechnology(technology);
        return personListByTechnology.stream().map(person -> getById(person.getIdPerson())
                        .orElseThrow(() -> new APIException("Person " + person.getIdPerson() + "not exist", HttpStatus.INTERNAL_SERVER_ERROR)))
                .toList();
    }

    @Override
    public List<ProfileDTO> getByExperienceOfYears(int years) {
        final List<ProfileDTO> allProfiles = getAll();
        return allProfiles.stream()
                .filter(profile -> profile.getAdditionalInfo().getYearsOfExperience() <= years)
                .toList();
    }

    private ProfileDTO setProfile(PersonDTO person) {
        final List<TechnologyDTO> technologies = technologyRepository.getByIdPerson(person.getIdPerson());
        final List<WorkExperienceDTO> workExperiences = workExperienceRepository.getByIdPerson(person.getIdPerson());
        final List<AcademicInfoDTO> academicInfoList = academicInfoRepository.getByIdPerson(person.getIdPerson());
        final AdditionalInfoDTO additionalInfo = setAdditionalInfo(person, workExperiences);
        return new ProfileDTO()
                .setPerson(person)
                .setAdditionalInfo(additionalInfo)
                .setTechnology(technologies)
                .setWorkExperience(workExperiences)
                .setAcademicInfo(academicInfoList);
    }

    private AdditionalInfoDTO setAdditionalInfo(PersonDTO person, List<WorkExperienceDTO> workExperiences) {
        final int yearsOfExperience = setYearsOfExperience(workExperiences);
        return new AdditionalInfoDTO()
                .setAge(getYears(person.getDateOfBirth()))
                .setYearsOfExperience(yearsOfExperience);
    }

    private int setYearsOfExperience(List<WorkExperienceDTO> workExperiences) {
        return workExperiences.stream()
                .mapToInt(x -> getYearsFromRange(x.getStartDate(), x.getEndDate()))
                .sum();
    }

    private int getYears(String date) {
        final LocalDate localDate = LocalDate.parse(date);
        final LocalDate localDateNow = LocalDate.now();
        final long years = YEARS.between(localDate, localDateNow);
        return (int) years;
    }

    private int getYearsFromRange(String dateOne, String dateTwo) {
        final LocalDate localDateOne = LocalDate.parse(dateOne);
        final LocalDate localDateTwo = LocalDate.parse(dateTwo);
        final long years = YEARS.between(localDateOne, localDateTwo);
        return years <= 0 ? 1 : (int) years;
    }

}
