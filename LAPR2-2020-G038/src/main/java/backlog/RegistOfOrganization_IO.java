package backlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.RegistOfOrganization;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistOfOrganization_IO {
        public static final String FILE_NAME = "RegistOfOrganization_IO.ro";

    public RegistOfOrganization_IO() {
    }

    public RegistOfOrganization read() {
        return read(FILE_NAME);
    }

    public RegistOfOrganization read(String fileName) {
        return read(new File(fileName));
    }

    public RegistOfOrganization read(File fileName) {
        RegistOfOrganization registOfOrganization;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                registOfOrganization = (RegistOfOrganization) in.readObject();
            } finally {
                
                in.close();
            }
            return registOfOrganization;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("dont");
            return new RegistOfOrganization();
        }
    }

    public boolean write(RegistOfOrganization registOfOrganization) {
        return write(FILE_NAME, registOfOrganization);
    }
    
    public boolean write(String fileName, RegistOfOrganization registOfOrganization) {
        return write(new File(fileName), registOfOrganization);
    }

    public boolean write(File fileName, RegistOfOrganization registOfOrganization) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            try {
                out.writeObject(registOfOrganization);
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
