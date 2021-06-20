package model;

import java.io.Serializable;

/**
 * Create a Manager
 *
 * @author LAPR2-2020-G038
 */
public class Manager implements Serializable {

    /**
     * Manager´s Name
     */
    private String name;
    /**
     * Manager´s Email
     */
    private String email;

    /**
     * Builds a Manager instance using parameters: name, email
     *
     * @param name Manager´s Name
     * @param email Manager´s Email
     */
    public Manager(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public Manager(Manager man) {
        this.name = man.name;
        this.email = man.email;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Name");
        }
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Email");
        }
        this.email = email;
    }

    /**
     * Returns a textual description of the Manager
     *
     * @return textual description of the Manager
     */
    @Override
    public String toString() {
        return String.format("Manager Information\nName: %s\nEmail: %s", getName(), getEmail());
    }

}
