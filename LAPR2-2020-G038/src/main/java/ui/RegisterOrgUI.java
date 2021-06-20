/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.AddOrganizationController;
import controller.FacadeController;
import controller.PlatformController;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class RegisterOrgUI implements Initializable {

    @FXML
    private TextField txtDes;
    @FXML
    private TextField txtNif;
    @FXML
    private TextField txtNameMan;
    @FXML
    private TextField txtEmailMan;
    @FXML
    private TextField txtNameCola;
    @FXML
    private TextField txtEmailCola;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnRegister;

    /**
     * Initializes the controller class.
     */
    MenuOfAdminUI AUI;
    FacadeController f = new FacadeController();
    AddOrganizationController org = new AddOrganizationController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfAdmin.fxml"));
        Parent root = loader.load();
        MenuOfAdminUI AUI = loader.getController();
        AUI.associateBack(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Register(ActionEvent event) throws FileNotFoundException {
        org.newOrganization(txtDes.getText().trim(), txtNif.getText().trim());
        org.newManager(txtNameMan.getText().trim(), txtEmailMan.getText().trim());
        org.newCollaborator(txtNameCola.getText().trim(), txtEmailCola.getText().trim());
        if (org.registerOrganization()) {
            AlertUI.createAlert(Alert.AlertType.INFORMATION, "Sucess", "Organization Registered with sucess");
        } else {
            AlertUI.createAlert(Alert.AlertType.ERROR, "Error", "An error occurred while registering the organization");

        }
    }

    public void associate(MenuOfAdminUI AUI) {
        this.AUI = AUI;
        f = AUI.GetFacade();
        org = AUI.getAddOrganization();
    }

    public AddOrganizationController getAddOrganization() {
        return org;
    }
}
