/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import autorization.model.SessaoUtilizador;
import backlog.RegistFreelancer_IO;
import backlog.RegistOfOrganization_IO;
import controller.FacadeController;
import controller.RegistFreelancerController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static model.LevelExpert.SENIOR;
import model.Platform;

import model.LevelExpert ;

/**
 * FXML Controller class
 *
 * @author Weeb
 */
public class RegisterFreelancerUI implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private TextField TxtID;
    @FXML
    private TextField TxtName;
    @FXML
    private TextField TxtEmail;
    @FXML
    private TextField TxtNIF;
    @FXML
    private TextField TxtIBAN;
    @FXML
    private TextField TxtAdress;
    @FXML
    private ComboBox<LevelExpert> cboxLvlExpert;
    @FXML
    private Button btnCreateTask;
    @FXML
    private Button btnRegisterFreelancer;
    @FXML
    private TextField TxtCountry;
    MenuOfCollaboratorUI ColaUI = new MenuOfCollaboratorUI();
    FacadeController f = new FacadeController();
  
    /**
     * Initializes the controller class.
     */
    RegistFreelancerController Rfree = new RegistFreelancerController();
    RegistFreelancer_IO IOfree = new RegistFreelancer_IO();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();
        LoginUI loginui = loader.getController();       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }



    @FXML
    private void CreateTask(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateTask.fxml"));
        Parent root = loader.load();
        CreateTaskUI taskUI = loader.getController();
        taskUI.associate(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
     public void  associate (MenuOfCollaboratorUI ColaUI) {
     this.ColaUI = ColaUI;
     f = ColaUI.GetFacade();
     System.out.println(f.getFacade().getSessaoAtual().getEmailUtilizador());
   cboxLvlExpert.getItems().setAll(LevelExpert.values());
    }

    @FXML
    private void RegisterFreelancer(ActionEvent event) {
       
        Rfree.NewFreelancer(TxtID.getText().trim(), TxtName.getText().trim(), cboxLvlExpert.getSelectionModel().getSelectedItem(), TxtEmail.getText().trim(), TxtNIF.getText().trim(), TxtIBAN.getText(), TxtAdress.getText().trim(), TxtCountry.getText().trim());
        Rfree.registFreelancer();
        
    }


    FacadeController GetFacade() {
          return f ;
    }
    
}
