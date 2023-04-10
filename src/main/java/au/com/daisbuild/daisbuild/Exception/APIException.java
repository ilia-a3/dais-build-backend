package au.com.daisbuild.daisbuild.Exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{
    HttpStatus status;
    String message;

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static APIException NOT_FOUND(String resourceName){
        return new APIException(HttpStatus.NOT_FOUND, "Could not find selected resource: " + resourceName);
    }
}
