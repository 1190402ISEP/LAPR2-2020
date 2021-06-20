/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backlog;

import static backlog.TaskList_IO.FILE_NAME;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.ListPayments;
import model.TaskList;

/**
 *
 * @author Weeb
 */
public class ListPayments_IO {
    public static final String FILE_NAME = "ListPayments_IO.Lp";
    public ListPayments_IO(){
    
 }
     public ListPayments read(String fileName) {
        return read(new File(fileName));
    }
     public ListPayments read(File fileName) {
        ListPayments listPayments;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                listPayments = (ListPayments) in.readObject();
            } finally {
                in.close();
            }
            return listPayments;
        } catch (IOException | ClassNotFoundException ex) {
            return new ListPayments();
        }
    }
     public ListPayments read() {
        ListPayments listPayments;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(FILE_NAME));
            try {
                listPayments = (ListPayments) in.readObject();
            } finally {
                in.close();
            }
             System.out.println("Is this it");
             System.out.println(listPayments);
            return listPayments;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("not again");
            return new ListPayments();
        }
}
      public boolean write(String fileName, ListPayments listPayments) {
        return write(new File(fileName), listPayments);
    }
      public boolean write(ListPayments listPayments) {
        return write(new File(FILE_NAME), listPayments);
    }
       public boolean write(File fileName, ListPayments listPayments) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                System.out.println(listPayments);
                System.out.println("I am here");
                out.writeObject(listPayments);
            } finally {
                out.flush();
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}