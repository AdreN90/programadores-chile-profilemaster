package cl.programadoreschile.adrian.profilemaster.controller;

import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;
import cl.programadoreschile.adrian.profilemaster.domain.services.ProfileService;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all profiles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get profile by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<ProfileDTO> getById(@PathVariable("id") String id) {
        return service.getById(id)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElseThrow(() -> new APIException("Profile " + id + " does not exist.", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/city/{city}")
    @ApiOperation(value = "Get profiles by city")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByCity(@PathVariable("city") String city) {
        return new ResponseEntity<>(service.getByCity(city), HttpStatus.OK);
    }

    @GetMapping("/country/{country}")
    @ApiOperation(value = "Get profiles by country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByCountry(@PathVariable("country") String city) {
        return new ResponseEntity<>(service.getByCountry(city), HttpStatus.OK);
    }

    @GetMapping("/changeOfAddress/{changeOfAddress}")
    @ApiOperation(value = "Get profiles by country")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByChangeOfAddress(@PathVariable("changeOfAddress") boolean changeOfAddress) {
        return new ResponseEntity<>(service.getByChangeOfAddress(changeOfAddress), HttpStatus.OK);
    }

    @GetMapping("/typeEducation/{typeEducation}")
    @ApiOperation(value = "Get profiles by typeEducation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByTypeEducation(@PathVariable("typeEducation") String typeEducation) {
        return new ResponseEntity<>(service.getByTypeEducation(typeEducation), HttpStatus.OK);
    }

    @GetMapping("/technology/{technology}")
    @ApiOperation(value = "Get profiles by technology")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByTechnology(@PathVariable("technology") String technology) {
        return new ResponseEntity<>(service.getByTechnology(technology), HttpStatus.OK);
    }

    @GetMapping("/experienceOfYears/{years}")
    @ApiOperation(value = "Get profiles by experience Of Years")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<ProfileDTO>> getByExperienceOfYears(@PathVariable("years") int years) {
        return new ResponseEntity<>(service.getByExperienceOfYears(years), HttpStatus.OK);
    }
}
