package model;

/**
 * Create an Exception - InvalidDesignationException
 *
 * @author LAPR2-2020-G038
 */
public class InvalidDesignationException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>InvalidDesignationException</code>
     * with a detail message: "Choose another designation for the Platform!"
     */
    public InvalidDesignationException() {
        super("Choose another designation for the Platform!");
    }

    /**
     * Constructs an instance of <code>InvalidDesignationException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidDesignationException(String msg) {
        super(msg);
    }
}
