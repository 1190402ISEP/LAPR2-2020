package model;

import autorization.AutorizacaoFacade;
import backlog.RegistFreelancer_IO;
import backlog.RegistOfOrganization_IO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import static model.PasswordGeneratorAlgorithm.FIX_QUANTITY_OF_CHARACTERS;

/**
 * Create a Platform
 *
 * @author LAPR2-2020-G038
 */
public class Platform   implements PasswordGeneratorAlgorithm, Serializable  {

    /**
     * Designation of the platform
     */
    private String designation;
    static RegistFreelancer_IO IOFreelancer= new RegistFreelancer_IO();
    static RegistOfOrganization_IO IOOrganization= new RegistOfOrganization_IO();
    private static RegistFreelancer registFreelancer = IOFreelancer.read();
    private static RegistOfOrganization registOfOrganization  = IOOrganization.read();

    /**
     * Builds a Platform instance using parameter her designation
     *
     * @param designation Designation of the platform
     */
    public Platform()  {
        setDesignation("PLATFORM");
        
    }

    /**
     * @return the design
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @return the registFreelancer
     */
    public static RegistFreelancer getRegistFreelancer() {
        return registFreelancer;
    }

    /**
     * @return the registOfOrganization
     */
    public static RegistOfOrganization getRegistOfOrganization() {
       
        return registOfOrganization;
    }

    /**
     * @param designation the design to set
     */
    public void setDesignation(String designation) {
        if (designation == null || designation.trim().isEmpty()) {
            throw new InvalidDesignationException("Choose another designation for the Platform!");
        }
        this.designation = designation;
    }

    /**
     * @param registFreelancer the registFreelancer to set
     */
    public void setRegistFreelancer(RegistFreelancer registFreelancer) {
        this.registFreelancer = registFreelancer;
    }

    /**
     * @param registOfOrganization the registOfOrganization to set
     */
    public void setRegistOfOrganization(RegistOfOrganization registOfOrganization) {
        this.registOfOrganization = registOfOrganization;
    }

    /**
     * Returns a textual description of the Platform
     *
     * @return textual description of the Platform
     */
    @Override
    public String toString() {
        return String.format("Platform Designation: %s", designation);
    }

    @Override
    public String generatePassword(String name, String email) {
        int qtdeMaximaCaracteres = FIX_QUANTITY_OF_CHARACTERS;
        String[] caracteres = {"0", "1", "b", "2", "4", "5", "6", "7", "8",
            "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();

    }

    public static  AutorizacaoFacade getAutorizationFacade() {
        return new AutorizacaoFacade();
    }

}
