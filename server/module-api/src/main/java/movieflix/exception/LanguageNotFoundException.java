package movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Ankan on 7/27/2017.
 */
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class LanguageNotFoundException extends RuntimeException
{

    private static final long serialVersionUID = 405802649322364762L;

    public LanguageNotFoundException(String message)
    {
        super(message);
    }
    public LanguageNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}