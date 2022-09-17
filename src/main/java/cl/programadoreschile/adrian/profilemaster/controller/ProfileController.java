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
}
