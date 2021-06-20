package controller;

import backlog.RegistFreelancer_IO;
import java.io.Serializable;
import model.Freelancer;
import model.InputTextInvalidException;
import model.LevelExpert;
import model.Platform;
import model.RegistFreelancer;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistFreelancerController implements Serializable{

    /**
     * Freelancer´s Regist
     */
    private RegistFreelancer rfree;
    /**
     * Freelancer
     */
    private Freelancer free;

    /**
     * Creates an instance of RegistFreelancerController
     */
    public RegistFreelancerController() {
    }

    /**
     * Creates a new Freelancer
     */
    public void NewFreelancer(String id, String name, LevelExpert levelExpert, String email, String NIF, String IBAN, String adress, String country) {
        try {
            setRfree(Platform.getRegistFreelancer());
            setFree(getRfree().newFreelancer(id, name, levelExpert, email, NIF, IBAN, adress, country));      
        } catch (InputTextInvalidException itie) {
            System.out.println(itie);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Validates and Add Freelancer to the system
     */
    public boolean registFreelancer() {
        if (getRfree().validateFreelancer(getFree())) {
            boolean check = getRfree().addFreelancer(getFree());
            RegistFreelancer_IO output = new RegistFreelancer_IO();
            check = output.write(getRfree());
            return check;
        }
        return false;
    }

    /**
     * @return the rfree
     */
    public RegistFreelancer getRfree() {
        return rfree;
    }

    /**
     * @param rfree the rfree to set
     */
    public void setRfree(RegistFreelancer rfree) {
        this.rfree = rfree;
    }

    /**
     * @return the free
     */
    public Freelancer getFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(Freelancer free) {
        this.free = free;
    }

    public void addFreelancertoRegist() {
        rfree.addFreelancer(free);
    }
}
