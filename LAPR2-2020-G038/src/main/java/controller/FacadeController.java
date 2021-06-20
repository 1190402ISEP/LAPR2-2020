/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import autorization.AutorizacaoFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import ui.LoginUI;

/**
 *
 * @author Weeb
 */
public class FacadeController {

    AutorizacaoFacade facada = new AutorizacaoFacade();

    public void CreateFacade() {
        try {
            facada.registaPapelUtilizador("Admin");
            facada.registaPapelUtilizador("Manager");
            facada.registaPapelUtilizador("Collaborator");
            Scanner in = new Scanner(new File("Users.txt"));
            while (in.hasNextLine()) {
                String a[] = in.nextLine().split(";");
                facada.registaUtilizadorComPapel(a[0].trim(), a[1].trim(), a[2].trim(), a[3].trim());
                System.out.println(a[0]+"-"+a[1]+"-"+a[2]+"-"+a[3]);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AutorizacaoFacade getFacade() {
        return facada;
    }
    public void getUsers() throws FileNotFoundException{
    Scanner in = new Scanner(new File("BackLog_Users.txt"));
     while (in.hasNextLine()) {
                String a[] = in.nextLine().split(";");
                facada.registaUtilizadorComPapel(a[0], a[1], a[2], a[3]);
                System.out.println(a[0]);
            }
            in.close();
}

}
