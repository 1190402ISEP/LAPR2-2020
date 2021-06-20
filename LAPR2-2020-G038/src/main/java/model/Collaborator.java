package model;

import java.io.Serializable;

/**
 * Create a Collaborator
 *
 * @author LAPR2-2020-G038
 */
public class Collaborator implements Serializable {

    /**
     * Collaborator´s Name
     */
    private String name;
    /**
     * Collaborator´s Email
     */
    private String email;

    /**
     * Builds a Collaborator instance using parameters: name, email
     *
     * @param name Collaborator´s Name
     * @param email Collaborator´s Email
     */
    public Collaborator(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public Collaborator(Collaborator colab) {
        this.name = colab.name;
        this.email = colab.email;
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
     * Returns a textual description of the Collaborator
     *
     * @return textual description of the Collaborator
     */
    @Override
    public String toString() {
        return String.format("Collaborator Information\nName: %s\nEmail: %s", getName(), getEmail());
    }

    /**
     * Compare Collaborator with the object received
     *
     * @param otherObject or object to compare with Collaborator.
     * @return true if the object received is an equivalent Collaborator and
     * false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Collaborator otherCollaborator = (Collaborator) otherObject;
        return name.equalsIgnoreCase(otherCollaborator.name) && email.equalsIgnoreCase(otherCollaborator.email);
    }
}
