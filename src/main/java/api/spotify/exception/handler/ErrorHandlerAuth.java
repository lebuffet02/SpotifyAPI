package api.spotify.exception.handler;

import api.spotify.exception.AuthException;
import api.spotify.exception.ErrorDetails;
import api.spotify.utils.IpUtils;
import api.spotify.utils.RandomUtils;
import api.spotify.utils.TimeUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerAuth extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorDetails> errorValidatingToken(AuthException ex) {
        ErrorDetails errorDetails = new ErrorDetails(TimeUtils.getZoneTimeWithClock(), ex.getMessage(), "externalError", RandomUtils.generateCode(), IpUtils.getAddress());
        return new ResponseEntity<>(errorDetails, HttpStatusCode.valueOf(500));
    }
}
