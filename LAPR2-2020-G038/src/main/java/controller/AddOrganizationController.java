package controller;

import backlog.RegistOfOrganization_IO;
import java.io.FileNotFoundException;
import model.Collaborator;
import model.Manager;
import model.Organization;
import model.Platform;
import model.RegistOfOrganization;

/**
 *
 * @author LAPR2-2020-G038
 */
public class AddOrganizationController {

    private RegistOfOrganization rOO;
    private Organization org;
    private Manager man;
    private Collaborator colab;

    public AddOrganizationController() {
       

    }
    //CHECK WHERE MUST THE FIRST LINE OF THIS METHOD IMPLEMENTED (CONTROLLER OR WHERE IS NOW!!!)
    public void newOrganization(String designation, String NIF) {
        rOO = Platform.getRegistOfOrganization();
        org = rOO.newOrganization(designation, NIF);
    }

    public void newManager(String nameMan, String emailMan) {
        man = org.newManager(nameMan, emailMan);
    }

    public void newCollaborator(String nameColab, String emailColab) {
        colab = org.newCollaborator(nameColab, emailColab);
    }

    public boolean registerOrganization() throws FileNotFoundException {
        if (rOO.validate(org)== true) {
            rOO.registerManagerAndCollaboratorLikeUsers(man, colab);
            boolean check=rOO.addOrganization(org);
            if(check==true){
                RegistOfOrganization_IO output= new RegistOfOrganization_IO();
            output.write(rOO);
            return check;
            }
        }
        return false;
    }
}
