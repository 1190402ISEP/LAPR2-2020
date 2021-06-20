/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import backlog.ListPayments_IO;
import backlog.TaskList_IO;
import controller.FacadeController;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ListPayments;
import model.NotFoundException;
import model.Payment;
/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class PaymentUI implements Initializable {

    @FXML
    private TextField txtTaskID;
    @FXML
    private Button Back;
    @FXML
    private Button btnPay;
    @FXML
    private TextField txtExecutionFinishDate;
    @FXML
    private TextField txtExecutionDelay;

    MenuOfCollaboratorUI MOC;
    TaskList_IO IOTaskList = new TaskList_IO();
    ListPayments Lp = new ListPayments();
    ListPayments_IO LpIO = new ListPayments_IO();
     
             
    /**
     * Initializes the controller class.
     */
    FacadeController f = new FacadeController();
    @FXML
    private TextField TxtExecutionBriefDescription;
    @FXML
    private TextField TxtShowAmout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuOfCollaborator.fxml"));
        Parent root = loader.load();
        MenuOfCollaboratorUI C = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void Pay(ActionEvent event) throws NotFoundException , FileNotFoundException {
        
        System.out.println(txtTaskID.getText());
        System.out.println(IOTaskList.read().getTaskList());
        Lp.addPayment(txtExecutionDelay.getText().trim(), txtExecutionFinishDate.getText().trim(), TxtExecutionBriefDescription.getText().trim(), IOTaskList.read().getTaskById(txtTaskID.getText().trim()), IOTaskList.read().getTaskById(txtTaskID.getText().trim()).getFreelancer());
        
        LpIO.write(Lp);
     
        
    }

    public void associate(MenuOfCollaboratorUI MOC) {
        this.MOC = MOC;
        f = MOC.GetFacade();

    }

    public FacadeController GetFacade() {
        return f;
    }

    @FXML
    private void showpayment(ActionEvent event) throws NotFoundException {
      Payment what = new Payment(txtExecutionDelay.getText().trim(), txtExecutionFinishDate.getText().trim(), TxtExecutionBriefDescription.getText().trim(), IOTaskList.read().getTaskById(txtTaskID.getText().trim()), IOTaskList.read().getTaskById(txtTaskID.getText().trim()).getFreelancer());
      String a =  String.valueOf(what.getAmmountCash());
      TxtShowAmout.setText(a);
    }
}
