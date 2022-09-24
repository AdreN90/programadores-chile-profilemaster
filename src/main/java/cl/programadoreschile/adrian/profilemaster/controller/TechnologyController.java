package cl.programadoreschile.adrian.profilemaster.controller;

import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.domain.services.TechnologyService;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyID;
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
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    private TechnologyService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all Technologies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<TechnologyDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPerson}/{idTechnology}")
    @ApiOperation(value = "Get technology by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<TechnologyDTO> getById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idTechnology") Integer idTechnology) {
        return service.getById(new TechnologyID()
                        .setIdPerson(idPerson)
                        .setIdTechnology(idTechnology))
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseThrow(() -> new APIException("Technology " + idTechnology + " does not exist.", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{idPerson}")
    @ApiOperation(value = "Get technology by idPerson")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<TechnologyDTO>> getByIdPerson(@PathVariable("idPerson") String idPerson) {
        return new ResponseEntity<>(service.getByIdPerson(idPerson), HttpStatus.OK);
    }

    @GetMapping("/technology/{technology}")
    @ApiOperation(value = "Get technology by technology")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<TechnologyDTO>> getByTechnology(@PathVariable("technology") String technology) {
        return new ResponseEntity<>(service.getByTechnology(technology), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save technology")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<TechnologyDTO> save(@Valid @RequestBody TechnologyDTO technology) {
        return new ResponseEntity<>(service.save(technology), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idPerson}/{idTechnology}")
    @ApiOperation(value = "Delete technology by id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<Object> deleteById(
            @PathVariable("idPerson") String idPerson,
            @PathVariable("idTechnology") Integer idTechnology) {
        service.deleteById(new TechnologyID()
                .setIdPerson(idPerson)
                .setIdTechnology(idTechnology));
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
