package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistOfPayments implements Serializable {

//tem que ter a List<Payment>
//construtor
//métodos get e set
//método toString() com StringBuilder
//devem ver que classe é que tem o registo de pagamentos se for a organização tem que ser adicionada a variável de instância à organização!!!
    private List<Payment> listPayment;

    public RegistOfPayments() {
        ///escrever código
    }

    /**
     * @return the listPayment
     */
    public List<Payment> getListPayment() {
        return listPayment;
    }

    /**
     * @param listPayment the listPayment to set
     */
    public void setListPayment(List<Payment> listPayment) {
        this.listPayment = listPayment;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Payment payment : listPayment) {
            s.append(payment);
            s.append("\n");
        }
        return s.toString();
    }

   
    
    public static double standardDeviation(double costPerHour[]) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = costPerHour.length;

        for (double num : costPerHour) {
            sum += num;
        }

        double mean = sum / length;

        for (double num : costPerHour) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / length);
    }

}
