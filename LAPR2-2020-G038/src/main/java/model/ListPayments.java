/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Weeb
 */
public class ListPayments implements Serializable {
     private List<Payment> PayList;
     
     public ListPayments() {
        PayList = new ArrayList<>();
    }
     public ListPayments(List<Payment> copy){
       PayList = copy;  
     }
   public void addPayment (String ExecutionDealy , String ExecutionFinishDate ,String ExecutionBriefDescription ,Task task, Freelancer free){
    Payment pay = new Payment(ExecutionDealy,ExecutionFinishDate,ExecutionBriefDescription,task,free);   
    getPayList().add(pay);
   }  
     
    public Payment getPaymentbyTaskId(String id){
       
        for (Payment pos : PayList) {
         if(pos.getTask().getId().equals(id) ){   
           return pos ;
                   }  
        }
       return PayList.get(0) ; 
    } 
     
     
      public String toString() {
        StringBuilder s = new StringBuilder();
           s.append("TaskID , TaskDescription, TaskAssignDuration(h), TaskCostPerHour(euros) ,ExecutionFinishDate, ExecutionDelay (hours), briefDesc, FreelancerID, FreelancerName, FreelancerExpertise ,FreelancerEMail,FreelancerNIF,FreelancerBanckAccout,FreelancerAddress,FreeLancerCountry \n");
        for (Payment pos : getPayList()) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }

    /**
     * @return the PayList
     */
    public List<Payment> getPayList() {
        return PayList;
    }

    /**
     * @param PayList the PayList to set
     */
    public void setPayList(List<Payment> PayList) {
        this.PayList = PayList;
    }
      
}
