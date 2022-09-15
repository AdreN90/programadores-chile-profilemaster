package cl.programadoreschile.adrian.profilemaster.controller;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.services.PersonService;
import cl.programadoreschile.adrian.profilemaster.error.APIException;
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
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all persons")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idPerson}")
    @ApiOperation(value = "Get person by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<Person> getById(@PathVariable("idPerson") String idPerson) {
        return personService.getPersonById(idPerson)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseThrow(() -> new APIException("Person " + idPerson + " does not exist.", HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save person")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = String.class),
            @ApiResponse(code = 404, message = "Not Found", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})
    public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }
}
