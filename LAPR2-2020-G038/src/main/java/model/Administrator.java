package model;

/**
 * Create an Administrator
 *
 * @author LAPR2-2020-G038
 */
public class Administrator {

    /**
     * Administrator Name
     */
    private String name;
    /**
     * Administrator ID
     */
    private String id;
    /**
     * Administrator Email
     */
    private String email;

    /**
     * Builds an Administrator instance using parameters: name, ID, email
     *
     * @param name Administrator Name
     * @param id Administrator ID
     * @param email Administrator Email
     */
    public Administrator(String name, String id, String email) {
        setName(name);
        setId(id);
        setEmail(email);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
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
     * @param id the id to set
     */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid ID");
        }
        this.id = id;
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
     * Returns a textual description of the Administrator
     *
     * @return textual description of the Administrator
     */
    @Override
    public String toString() {
        return String.format("Administrator Info\nName: %s\nID: %s\nEmail: %s", name, id, email);
    }

}
