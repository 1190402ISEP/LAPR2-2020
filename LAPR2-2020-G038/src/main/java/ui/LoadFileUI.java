/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.FileType;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class LoadFileUI implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private Button Add;
    @FXML
    private Button btnTxt;
    @FXML
    private Button btnCsv;
    @FXML
    private TextArea Txtfile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfCollaborador.fxml")) ;
        Parent root = loader.load();
        MenuOfCollaboratorUI grap = loader.getController() ; 
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();   
    }

    @FXML
    private void Add(ActionEvent event) {
    }

    @FXML
    private void btnTxtAction(ActionEvent event) {
        javafx.stage.FileChooser flChooser = FileChooser.createFileChooser(FileType.FILE_TXT.toString());
        File selectedFile = flChooser.showOpenDialog(null);
        
    }

    @FXML
    private void btnCsvAction(ActionEvent event) {
        javafx.stage.FileChooser flChooser = FileChooser.createFileChooser(FileType.FILE_CSV.toString());
        File selectedFile = flChooser.showOpenDialog(null);
    }

}
