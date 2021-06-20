package model;

/**
 * Create an Exception - InputTextInvalidException
 *
 * @author LAPR2-2020-G038
 */
public class InputTextInvalidException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>TextFormatErrorException</code> with the detail message: "Inserted Text Is Invalid"
     */
    public InputTextInvalidException() {
        super("Inserted Text Is Invalid");
    }

    /**
     * Constructs an instance of <code>TextFormatErrorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InputTextInvalidException(String msg) {
        super(msg);
    }
}
