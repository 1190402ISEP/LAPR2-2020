/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class AddFreelancerController implements Initializable {

    @FXML
    private TextField Id;
    @FXML
    private TextField briefDesc;
    @FXML
    private TextField timeDuration;
    @FXML
    private TextField costPerHour;
    @FXML
    private TextField taskCategory;
    @FXML
    private Button Back;
    @FXML
    private Button Add;
    @FXML
    private TextField Freelancer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void Add(ActionEvent event) {
    }
    
}
