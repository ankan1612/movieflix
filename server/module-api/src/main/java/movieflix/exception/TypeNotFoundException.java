package movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ankan on 7/24/2017.
 */

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class TypeNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 405802649322364762L;

    public TypeNotFoundException(String message)
    {
        super(message);
    }
    public TypeNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}