/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author jl4ma
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor vacío.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que establece el mensaje de la excepción.
     *
     * @param message de la excepción
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que establece el mensaje y la causa de la excepción.
     *
     * @param message de la excepción
     * @param cause de la excepción
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que establece la causa de la excepción.
     *
     * @param cause de la excepción
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que establece el mensaje y causa especificados
     * @param message El detalle del mensaje asociado a la excepción.
     * @param cause La causa que desencadenó esta excepción. Puede ser nulo si
     * la causa no se conoce o no está disponible.
     * @param enableSuppression Un valor booleano que indica si la supresión de
     * la excepción está habilitada o deshabilitada.
     * @param writableStackTrace Un valor booleano que indica si el rastreo de
     * pila es modificable.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
