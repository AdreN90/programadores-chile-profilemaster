package cl.programadoreschile.adrian.profilemaster.controller;

import cl.programadoreschile.adrian.profilemaster.domain.entities.WorkExperienceDTO;
import cl.programadoreschile.adrian.profilemaster.domain.services.WorkExperienceService;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/work-experience")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all work experiences")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<WorkExperienceDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPerson}/{idWorkExperience}")
    @ApiOperation(value = "Get work experience by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<WorkExperienceDTO> getById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idWorkExperience") Integer idWorkExperience) {
        return service.getById(new WorkExperienceID()
                        .setIdPerson(idPerson)
                        .setIdWorkExperience(idWorkExperience))
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseThrow(() -> new APIException("Work experience " + idWorkExperience + " does not exist.", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idPerson}")
    @ApiOperation(value = "Get all work experiences")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<WorkExperienceDTO>> getByIdPerson(@PathVariable("idPerson") String idPerson) {
        return new ResponseEntity<>(service.getByIdPerson(idPerson), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save work experience")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<WorkExperienceDTO> save(@Valid @RequestBody WorkExperienceDTO workExperience) {
        return new ResponseEntity<>(service.save(workExperience), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idPerson}/{idWorkExperience}")
    @ApiOperation(value = "Delete work experience by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<Object> deleteById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idWorkExperience") Integer idWorkExperience) {
        service.deleteById(new WorkExperienceID()
                .setIdPerson(idPerson)
                .setIdWorkExperience(idWorkExperience));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
