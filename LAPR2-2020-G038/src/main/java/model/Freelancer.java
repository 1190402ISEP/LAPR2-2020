package model;

import java.io.Serializable;

/**
 * Create a Freelancer
 *
 * @author LAPR2-2020-G038
 */
public class Freelancer implements Serializable {

    /**
     * Freelancer´s ID
     */
    private String id;
    /**
     * Freelancer´s Name
     */
    private String name;
    /**
     * Freelancer´s Level Expert
     */
    private LevelExpert levelExpert;
    /**
     * Freelancer´s Email
     */
    private String email;
    /**
     * Freelancer´s NIF
     */
    private String NIF;
    /**
     * Freelancer´s IBAN
     */
    private String IBAN;
    /**
     * Freelancer´s Adress
     */
    private String adress;
    /**
     * Freelancer´s Country
     */
    private String country;

    /**
     * Builds a Freelancer instance using parameters: id, name, level expert,
     * email, NIF, IBAN , adress and country
     *
     * @param id Freelancer´s ID
     * @param name Freelancer´s Name
     * @param levelExpert Freelancer´s Level Expert
     * @param email Freelancer´s Email
     * @param NIF Freelancer´s NIF
     * @param IBAN Freelancer´s IBAN
     * @param adress Freelancer´s Adress
     * @param country Freelancer´s Country
     */
    public Freelancer(String id, String name, LevelExpert levelExpert, String email, String NIF, String IBAN, String adress, String country) {
        setId(id);
        setName(name);
        this.levelExpert = levelExpert;
        setEmail(email);
        setNIF(NIF);
        setIBAN(IBAN);
        setAdress(adress);
        setCountry(country);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the levelExpert
     */
    public LevelExpert getLevelExpert() {
        return levelExpert;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @return the IBAN
     */
    public String getIBAN() {
        return IBAN;
    }

    /**
     * @return the address
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
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
     * @param name the name to set
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Name");
        }
        this.name = name;
    }

    /**
     * @param levelExpert the levelExpert to set
     */
    public void setLevelExpert(LevelExpert levelExpert) {
        this.levelExpert = levelExpert;
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
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        if (NIF == null || NIF.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid NIF");
        }
        this.NIF = NIF;
    }

    /**
     * @param IBAN the IBAN to set
     */
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    /**
     * @param adress the address to set
     */
    public void setAdress(String adress) {
        if (adress == null || adress.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Adress");
        }
        this.adress = adress;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Country");
        }
        this.country = country;
    }

    /**
     * Returns a textual description of the Freelancer
     *
     * @return textual description of the Freelancer
     */
    @Override
    public String toString() {
        return String.format("Freelancer Info:\nID: %S\nName: %s\nLevelExpert: %s\nEmail: %s\nNIF: %S\nIBAN: %s\nAdress: %s\nCountry: %s", id, name, levelExpert, email, NIF, IBAN, adress, country);
    }

    /**
     * Compare Freelancer with the object received
     *
     * @param otherObject or object to compare with Freelancer.
     * @return true if the object received is an equivalent Freelancer and false
     * otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Freelancer otherFreelancer = (Freelancer) otherObject;
        return id.equalsIgnoreCase(otherFreelancer.id) && name.equalsIgnoreCase(otherFreelancer.name) && levelExpert.toString().equalsIgnoreCase(otherFreelancer.levelExpert.toString()) && email.equalsIgnoreCase(otherFreelancer.email) && NIF.equalsIgnoreCase(otherFreelancer.NIF) && IBAN.equalsIgnoreCase(otherFreelancer.IBAN) && adress.equalsIgnoreCase(otherFreelancer.adress) && country.equalsIgnoreCase(otherFreelancer.country);
    }

}