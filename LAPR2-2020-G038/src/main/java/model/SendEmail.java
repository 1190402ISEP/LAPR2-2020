package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;

/**
 *
 * @author LAPR2-2020-G038
 */
public class SendEmail {

    public static boolean SendEmailNewUser(String name, String email, String password, String function) {

        String motivOfEmail = " Regist Of New User";
        File file = new File(motivOfEmail + email + ".txt");
        try {
            Formatter formatter = new Formatter(file);
            try {
                formatter.format("Hello %s\n(%s)Your regist data:\nName:%s\nEmail: %s\nTo acess the app use the following password:\n%s",name,function,name,email,password);
                return true;
            } catch (IllegalFormatException | FormatterClosedException e) {
                return false;
            } finally {
                formatter.close();
            }
        } catch (FileNotFoundException fnfe) {
            return false;
        }
    }
}
