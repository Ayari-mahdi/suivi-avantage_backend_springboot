package rest_karama1.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long seriaLVersionUID = 1L;

    public  ResourceNotFoundException(String message) {
        super(String.valueOf(message));
        //return message ;
    }
}