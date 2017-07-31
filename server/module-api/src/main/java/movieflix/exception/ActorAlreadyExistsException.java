package movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ankan on 7/26/2017.
 */

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class ActorAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 405802649322364762L;

    public ActorAlreadyExistsException(String message) {
        super(message);
    }

    public ActorAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}