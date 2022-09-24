package cl.programadoreschile.adrian.profilemaster.domain.entities;

public class AdditionalInfoDTO {

    private int age;
    private int yearsOfExperience;

    public int getAge() {
        return age;
    }

    public AdditionalInfoDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public AdditionalInfoDTO setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
        return this;
    }
}
