/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.FacadeController;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class MenuOfCollaboratorUI implements Initializable {

    @FXML
    private Button paymentTransactions;
    @FXML
    private Button Performace;
    @FXML
    private Button logOut;
    @FXML
    private Label UserName;
    @FXML
    private Label ID;
    @FXML
    private Button LoadFile;
    LoginUI login ;
     FacadeController f = new FacadeController();
     
    @FXML
    private Button RegisterFreelacer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void paymentTransactions(ActionEvent event) throws IOException {
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Payment.fxml")) ;
        Parent root = loader.load();
        PaymentUI PUI = loader.getController() ; 
        PUI.associate(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    private void Performace(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Graphic.fxml")) ;
        Parent root = loader.load();
        GraphicUI grap = loader.getController() ; 
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
 ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Parent root = loader.load();
        LoginUI loginui = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
    }

    @FXML
    private void LoadFile(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoadFile.fxml")) ;
        Parent root = loader.load();
        LoadFileUI grap = loader.getController() ; 
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    

    @FXML
    private void goToRegisterFreelancer(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegisterFreelancer.fxml")) ;
        Parent root = loader.load();
        RegisterFreelancerUI FreeUI = loader.getController() ;
        FreeUI.associate(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
     public void  associate (LoginUI loginUI) {
     this.login = loginUI;
     f = login.GetFacade();
     UserName.setText(f.getFacade().getSessaoAtual().getNomeUtilizador());
     ID.setText(f.getFacade().getSessaoAtual().getIdUtilizador());
    }  
    public FacadeController GetFacade() {
        return f;
    }

  
    
}
