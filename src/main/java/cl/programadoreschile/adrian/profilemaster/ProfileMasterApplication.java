package cl.programadoreschile.adrian.profilemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cl.*"})
public class ProfileMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileMasterApplication.class, args);
    }

}
