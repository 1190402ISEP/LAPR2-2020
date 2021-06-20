/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Create an Exception - NotFoundException
 *
 * @author LAPR2-2020-G038
 */
public class NotFoundException extends Exception {

    /**
     * Creates a new instance of <code>NotFoundException</code> with the message "Not Found"
     */
    public NotFoundException() {
        super("Not Found");
    }

    /**
     * Constructs an instance of <code>NotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotFoundException(String msg) {
        super(msg);
    }
}
