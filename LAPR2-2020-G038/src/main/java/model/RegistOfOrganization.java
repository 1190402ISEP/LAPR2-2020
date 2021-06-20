package model;

import autorization.AutorizacaoFacade;
import backlog.RegistOfOrganization_IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LAPR2-2020-G038
 */
public class RegistOfOrganization implements Serializable {

    private List<Organization> organizationList;
    private Platform plat;
    private static final String FILENAME = "USERS.txt";

    public RegistOfOrganization() {

        organizationList = new ArrayList<>();
        plat = new Platform();
    }

    public RegistOfOrganization(List<Organization> copy) {
        organizationList = new ArrayList<>(copy);
    }

    public Organization getOrganizationByEmailCollaborator(String email) throws NotFoundException {
        boolean check = false;
        for (Organization pos : getOrganizationList()) {
            String posEmail = pos.getColab().getEmail();
            check = email.equalsIgnoreCase(posEmail);
            if (check == true) {
                return pos;
            }
        }
        throw new NotFoundException("Organization not Found!");
    }

    public Organization newOrganization(String designation, String NIF) {
        Organization org = new Organization(designation, NIF);
        return org;
    }

    public boolean validate(Organization org) {
        return getOrganizationList().contains(org) ? false : true;
    }

    public void registerManagerAndCollaboratorLikeUsers(Manager man, Collaborator colab) throws FileNotFoundException {
        String nameManager = man.getName();
        String emailManager = man.getEmail();

        String nameCollaborator = colab.getName();
        String emailCollaborator = colab.getEmail();

        String pwdManager = plat.generatePassword(nameManager, emailManager);
        String pwdCollaborator = plat.generatePassword(nameCollaborator, emailCollaborator);

        AutorizacaoFacade aut = Platform.getAutorizationFacade();

        aut.registaUtilizadorComPapel(nameManager, emailManager, pwdManager, "Manager");
        aut.registaUtilizadorComPapel(nameCollaborator, emailCollaborator, pwdCollaborator, "Collaborator");

        SendEmail.SendEmailNewUser(nameManager, emailManager, pwdManager, "Manager");
        SendEmail.SendEmailNewUser(nameCollaborator, emailCollaborator, pwdCollaborator, "Collaborator");
        String[][] backup = new String[20][4];
        backup=read(backup);
        write(backup, nameManager, emailManager, pwdManager, "Manager", nameCollaborator, emailCollaborator, pwdCollaborator, "Collaborator");

    }

    public boolean addOrganization(Organization org) {
        return getOrganizationList().add(org);
    }

    private String[][] read(String[][] backup) throws FileNotFoundException {

        File file = new File(FILENAME);
        Scanner read = new Scanner(file);
        int i = 0;

        while (read.hasNextLine() && i < 20) {

            String linha = read.nextLine();
            String[] itensDaLinha = linha.split(";");
            for (int pos = 0; pos < 4; pos++) {
                backup[i][pos] = itensDaLinha[pos];
            }
            i++;
        }
        read.close();
        return backup;
    }

    private void write(String[][] backup, String nameManager, String emailManager, String pwdManager, String manager, String nameCollaborator, String emailCollaborator, String pwdCollaborator, String collaborator) throws FileNotFoundException {
        Formatter out = new Formatter(FILENAME);
        int i=0;
        while(backup [i][0] != null){
              out.format(backup [i][0]+";"+backup [i][1]+";"+backup [i][2]+";"+backup [i][3]);  
              i++;
            }
        out.format("\n");
        out.format(nameManager + ";" + emailManager + ";" + pwdManager + ";Manager\n" + nameCollaborator + ";" + emailCollaborator + ";" + pwdCollaborator + ";Collaborator");
        out.close();

    }

    /**
     * @return the organizationList
     */
    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    /**
     * @param organizationList the organizationList to set
     */
    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

}
