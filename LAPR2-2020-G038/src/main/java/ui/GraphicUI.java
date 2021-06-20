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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class GraphicUI implements Initializable {

    @FXML
    private BarChart<?, ?> graphic;
    @FXML
    private NumberAxis X;
    @FXML
    private CategoryAxis Y;
    @FXML
    private Button Voltar;
    @FXML
    private Button Math;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Voltari(ActionEvent event) {
    }

    @FXML
    private void Math(ActionEvent event) {
    }
    
}
