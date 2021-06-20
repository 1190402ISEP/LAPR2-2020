/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import model.Freelancer;
import model.InputTextInvalidException;
import model.ListPayments;
import model.Organization;
import model.Platform;
import model.Payment;
import model.Task;

public class PaymentController implements Serializable {
   private ListPayments Lpay;
   
    public void NewPayment(String ExecutionDealy , String ExecutionFinishDate ,String ExecutionBriefDescription , Task task, Freelancer free ){
 
        getLpay().addPayment(ExecutionDealy, ExecutionFinishDate, ExecutionBriefDescription, task, free);
        
    }

    /**
     * @return the Lpay
     */
    public ListPayments getLpay() {
        return Lpay;
    }

    /**
     * @param Lpay the Lpay to set
     */
    public void setLpay(ListPayments Lpay) {
        this.Lpay = Lpay;
    }
}
        
    

