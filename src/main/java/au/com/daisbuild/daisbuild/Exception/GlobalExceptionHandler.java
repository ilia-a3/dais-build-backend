package au.com.daisbuild.daisbuild.Exception;

import au.com.daisbuild.daisbuild.payload.StatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<StatusResponse> handleAPIException(APIException exception, WebRequest request) {
        StatusResponse res = new StatusResponse(exception.getStatus().getReasonPhrase(), exception.getMessage());
        System.out.println("Handled APIException \t " + res.getMessage());
        return new ResponseEntity<>(res, exception.getStatus());
    }
}
