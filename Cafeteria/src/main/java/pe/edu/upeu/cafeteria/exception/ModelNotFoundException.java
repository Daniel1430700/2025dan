package pe.edu.upeu.cafeteria.exception;
// esta clase sirve para manejo de errores
import lombok.Getter;

@Getter
public class ModelNotFoundException extends RuntimeException{
    private final int errorCode;
    public ModelNotFoundException(String message) {
        super(message);
        this.errorCode = 0; // 0 = código genérico
    }
    public ModelNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}