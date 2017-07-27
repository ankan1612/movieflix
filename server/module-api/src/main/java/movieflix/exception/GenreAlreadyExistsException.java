package movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ankan on 7/27/2017.
 */
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class GenreAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 405802649322364762L;

    public GenreAlreadyExistsException(String message) {
        super(message);
    }

    public GenreAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
