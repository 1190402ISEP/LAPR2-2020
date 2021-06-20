package model;

/**
 * Create an Exception - NumberOutOfLimitsException
 *
 * @author LAPR2-2020-G038
 */
public class NumberOutOfLimitsException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>NumberOutOfLimitsException</code> with the message "Number Out Of Limits"
     */
    public NumberOutOfLimitsException() {
        super("Number Out Of Limits");
    }
    

    /**
     * Constructs an instance of <code>NumberOutOfLimitsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NumberOutOfLimitsException(String msg) {
        super(msg);
    }
}
