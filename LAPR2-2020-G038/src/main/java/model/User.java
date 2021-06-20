package model;

import java.io.Serializable;

/**
 * Create an User
 *
 * @author LAPR2-2020-G038
 */
public class User implements Serializable {

    /**
     * User Name
     */
    private String name;
    /**
     * User Email
     */
    private String email;
    /**
     * User Password
     */
    private String pwd;
    /**
     * User Function
     */
    private String function;

    /**
     * Builds an User instance using parameters: name, email , password, function
     * @param name User Name
     * @param email User Email
     * @param pwd User Password
     * @param function User Function
     */
    public User(String name, String email, String pwd, String function) {
        setName(name);
        setEmail(email);
        setPwd(pwd);
        setFunction(function);
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
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new InputTextInvalidException("Invalid Name");
        }
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()){
            throw new InputTextInvalidException("Invalid Email");
        }
        this.email = email;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        if(pwd == null || pwd.trim().isEmpty()){
            throw new InputTextInvalidException("Invalid Password");
        }
        this.pwd = pwd;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(String function) {
        if(function == null || function.trim().isEmpty()){
            throw new InputTextInvalidException("Invalid Function");
        }
        this.function = function;
    }

/**
     * Returns a textual description of the User
     *
     * @return textual description of the User
     */
    @Override
    public String toString() {
        return String.format("User Information:\nName: %s\nEmail: %s\nPwd: %s\nFunction: %s", getName(), getEmail(), getPwd(), getFunction());
    }

    
}
