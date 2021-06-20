package backlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RegistFreelancer;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistFreelancer_IO {

    public static final String FILE_NAME = "RegistFreelancer_IO.rf";

    public RegistFreelancer_IO() {
    }

    public RegistFreelancer read() {
        return read(FILE_NAME);
    }

    public RegistFreelancer read(String fileName) {
        return read(new File(fileName));
    }

    public RegistFreelancer read(File fileName) {
        RegistFreelancer registFreelancer;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                registFreelancer = (RegistFreelancer) in.readObject();
            } finally {
                in.close();
            }
            return registFreelancer;
        } catch (IOException | ClassNotFoundException ex) {
           
            
            return new RegistFreelancer();
        }
    }
     public RegistFreelancer readw(String fileName) throws IOException, ClassNotFoundException {
         File file = new File(fileName);
         RegistFreelancer registFreelancer;
       ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
       registFreelancer = (RegistFreelancer) in.readObject();
       return registFreelancer;
    }

    public boolean write(RegistFreelancer registFreelancer) {
        return write(FILE_NAME, registFreelancer);
    }

    public boolean write(String fileName, RegistFreelancer registFreelancer) {
        return write(new File(fileName), registFreelancer);
    }

    public boolean write(File fileName, RegistFreelancer registFreelancer) {
     
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            try {
                System.out.println(registFreelancer + "YO this a test");
                out.writeObject(registFreelancer);
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
