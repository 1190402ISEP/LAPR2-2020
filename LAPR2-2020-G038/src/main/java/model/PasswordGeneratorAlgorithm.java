package model;

/**
 * @author LAPR2-2020-G038
 */
public interface PasswordGeneratorAlgorithm {
    int FIX_QUANTITY_OF_CHARACTERS = 7;
    String generatePassword(String name, String email);
    
}
