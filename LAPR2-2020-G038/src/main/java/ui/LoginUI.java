/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import autorization.AutorizacaoFacade;
import backlog.ListPayments_IO;
import backlog.RegistFreelancer_IO;
import backlog.RegistOfOrganization_IO;
import backlog.TaskList_IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.sun.istack.internal.logging.Logger;
import controller.AddOrganizationController;
import controller.FacadeController;
import controller.PlatformController;
import controller.RegistFreelancerController;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import model.LevelExpert;
import model.NotFoundException;
import model.Platform;

import sun.util.logging.PlatformLogger;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class LoginUI implements Initializable {

    @FXML
    private TextField Username;
    @FXML
    private TextField Password;

    FacadeController f = new FacadeController();
    AddOrganizationController org = new AddOrganizationController();
    MenuOfAdminUI AUI = new MenuOfAdminUI();
    File file = new File("BackLog_Users.txt");
    RegistFreelancer_IO IOfree = new RegistFreelancer_IO();
    RegistOfOrganization_IO IOorg = new RegistOfOrganization_IO();
    RegistFreelancerController Rfree = new RegistFreelancerController();
     TaskList_IO IOTaskList = new TaskList_IO();
     ListPayments_IO Plop ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    
        try {
            System.out.println(IOTaskList.read().getTaskById("12345")+"\n gmaer");
        } catch (NotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(Plop.read().getPayList());
      f.CreateFacade();

    }

    @FXML
    private void Login(ActionEvent event) throws IOException, NotFoundException {
        f.getFacade().doLogout();
        
        if (file.exists() == true) {
            f.getUsers();
        }

        f.getFacade().doLogin(Username.getText().trim(), Password.getText().trim());
     
        if (f.getFacade().getSessaoAtual().isLoggedInComPapel("Admin") == true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfAdmin.fxml"));
            Parent root = loader.load();
            MenuOfAdminUI A = loader.getController();
            A.associate(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();

        }

        if (f.getFacade().getSessaoAtual().isLoggedInComPapel("Manager") == true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfManager.fxml"));
            Parent root = loader.load();
            MenuOfManagerUI M = loader.getController();
            M.associate(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        }

        if (f.getFacade().getSessaoAtual().isLoggedInComPapel("Collaborator") == true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfCollaborator.fxml"));
            Parent root = loader.load();
            MenuOfCollaboratorUI C = loader.getController();
            C.associate(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        }

    }

    public FacadeController GetFacade() {
        return f;
    }

    public AddOrganizationController getAddOrganization() {
        return org;
    }

    public void associateBack(MenuOfAdminUI AUI) {
        this.AUI = AUI;
        org = AUI.getAddOrganization();
    }
}
