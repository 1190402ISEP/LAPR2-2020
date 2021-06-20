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
public class MenuOfManagerUI implements Initializable {

    @FXML
    private Label UserName;
    @FXML
    private Button schedulePayment;
    @FXML
    private Button Performance;
    @FXML
    private Button logOut;
    @FXML
    private Label ID;
    LoginUI login ;
    FacadeController f = new FacadeController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void schedulePayment(ActionEvent event) {
    }

    @FXML
    private void Performance(ActionEvent event) {
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml")) ;
        Parent root = loader.load();
        LoginUI grap = loader.getController() ; 
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
}
