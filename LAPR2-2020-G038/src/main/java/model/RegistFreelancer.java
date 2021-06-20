/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import backlog.RegistFreelancer_IO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistFreelancer implements Serializable {

    /**
     * Freelancer List
     */
    private List<Freelancer> registFreelancer;
     

    /**
     * Creates an instance of RegistFreelancer
     */
    public RegistFreelancer() {
        this.registFreelancer =new ArrayList<>() ;
   
    
    }

    public RegistFreelancer(List<Freelancer> copy) {
        this.registFreelancer = new ArrayList<>(copy);
    }

    /**
     * @return the registFreelancer
     */
    public List<Freelancer> getRegistFreelancer() {
        return registFreelancer;
    }
    public Freelancer getFreelancerbyName(String Nome){
        for (int i = 0; i <registFreelancer.size() ; i++) {
           
          if(registFreelancer.get(i).getName().equals(Nome)){
          
            return  registFreelancer.get(i);
            
        }
                    
        }
 return registFreelancer.get(0);
    }

    /**
     * @param registFreelancer the registFreelancer to set
     */
    public void setRegistFreelancer(List<Freelancer> registFreelancer) {
        this.registFreelancer = registFreelancer;
    }

    /**
     * Returns a textual description of the Freelancer Regist
     *
     * @return textual description of the Freelancer Regist
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Freelancer pos : getRegistFreelancer()) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }

    /**
     * Check is the list is empty
     *
     * @return true if empty, false if not empty
     */
    public boolean isEmpty() {
        return getRegistFreelancer().isEmpty();
    }

    /**
     * Creates an instance of Freelancer
     */
    public Freelancer newFreelancer(String id, String name, LevelExpert levelExpert, String email, String NIF, String IBAN, String adress, String country) {
        Freelancer free = new Freelancer(id, name, levelExpert, email, NIF, IBAN, adress, country);
        return free;
    }

    /**
     * Validate Freelancer
     */
    public boolean validateFreelancer(Freelancer free) {
        return getRegistFreelancer().contains(free) ? false : true;
    }

    /**
     * Add a Freelancer to the System
     */
    public boolean addFreelancer(Freelancer free) {
        return getRegistFreelancer().add(free);

    }

    public boolean verifyFreelancer(Freelancer NIF) {
        for (int i = 0; i < getRegistFreelancer().size(); i++) {
            if (getRegistFreelancer().get(i).equals(NIF)) {
                return true;
            }

        }
        return false;
    }
}
