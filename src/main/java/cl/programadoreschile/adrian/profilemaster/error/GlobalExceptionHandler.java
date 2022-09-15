package cl.programadoreschile.adrian.profilemaster.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = APIException.class)
    public ResponseEntity<Object> handleAPIException(APIException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<Object> handleMismatchException(Exception ex) {
        return new ResponseEntity<>(getMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<Object> handleConstraintViolationException(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        return new ResponseEntity<>(details.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getMessage(String message) {
        String[] parts = message.split("\\.");
        String[] variable = parts[parts.length - 1].split("\"");
        return "Invalida format: " + variable[1];
    }

}


