package exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (String message) {
        super(message);
    }

}
