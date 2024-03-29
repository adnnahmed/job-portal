package personal.projects.jobportal.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import personal.projects.jobportal.exceptions.CustomException;
import personal.projects.jobportal.exceptions.ResourceUnavailableException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceUnavailableException.class)
    public ResponseEntity<Object> handleResourceUnavailableException(ResourceUnavailableException resourceUnavailableException) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomException customException = new CustomException(
                resourceUnavailableException.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(customException, httpStatus);
    }
}
