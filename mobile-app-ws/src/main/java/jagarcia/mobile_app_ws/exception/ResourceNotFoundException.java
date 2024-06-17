package jagarcia.mobile_app_ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP 404 (Not Found).
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /*
    resourceName: El nombre del recurso que no se encontró.
    fieldName: El nombre del campo utilizado para buscar el recurso.
    fieldValue: El valor del campo utilizado en la búsqueda.
    * */
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String rosourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : '%s'", rosourceName, fieldName, fieldValue));
        this.resourceName = rosourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
