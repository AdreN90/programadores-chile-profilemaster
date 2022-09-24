package cl.programadoreschile.adrian.profilemaster.controller;

import cl.programadoreschile.adrian.profilemaster.domain.entities.AcademicInfoDTO;
import cl.programadoreschile.adrian.profilemaster.domain.services.AcademicInfoService;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;
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
@RequestMapping("/academic-info")
public class AcademicInfoController {

    @Autowired
    private AcademicInfoService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all academic info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<AcademicInfoDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPerson}/{idAcademicInfo}")
    @ApiOperation(value = "Get academic info by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<AcademicInfoDTO> getById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idAcademicInfo") Integer idAcademicInfo) {
        return service.getById(new AcademicInfoID()
                        .setIdPerson(idPerson)
                        .setIdAcademicInfo(idAcademicInfo))
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseThrow(() -> new APIException("Academic information " + idAcademicInfo + " does not exist.", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idPerson}")
    @ApiOperation(value = "Get all academic info by idPerson")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<AcademicInfoDTO>> getByIdPerson(@PathVariable("idPerson") String idPerson) {
        return new ResponseEntity<>(service.getByIdPerson(idPerson), HttpStatus.OK);
    }

    @GetMapping("/typeEducation/{typeEducation}")
    @ApiOperation(value = "Get all academic info by typeEducation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<AcademicInfoDTO>> getByTypeEducation(@PathVariable("typeEducation") String typeEducation) {
        return new ResponseEntity<>(service.getByTypeEducation(typeEducation), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save academic info")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<AcademicInfoDTO> save(@Valid @RequestBody AcademicInfoDTO academicInfo) {
        return new ResponseEntity<>(service.save(academicInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idPerson}/{idAcademicInfo}")
    @ApiOperation(value = "Delete academic info by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<Object> deleteById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idAcademicInfo") Integer idAcademicInfo) {
        service.deleteById(new AcademicInfoID()
                .setIdPerson(idPerson)
                .setIdAcademicInfo(idAcademicInfo));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
