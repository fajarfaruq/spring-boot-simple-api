package id.my.fajarfaruq.simpleapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** ResourceNotFoundException Class. This class using for handle not found error in the API
 *
 * @author Fajar Faruq
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    
    // SerialVersionUID is a unique identifier for each class, 
    // JVM uses it to compare the versions of the class ensuring that the same class was used during Serialization is loaded during Deserialization
    // In this case using for keep class ResourceNotFoundException keep alive while API process
    private static final long serialVersionUID = 1L;

    /**
     * ResourceNotFoundException Method. This method using for 
     * @param message   
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
