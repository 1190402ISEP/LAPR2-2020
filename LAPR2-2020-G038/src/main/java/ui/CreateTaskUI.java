/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import autorization.model.SessaoUtilizador;
import backlog.RegistFreelancer_IO;
import backlog.RegistOfOrganization_IO;
import backlog.TaskList_IO;
import controller.CreateTaskController;
import controller.FacadeController;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
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
import model.NotFoundException;
import model.Platform;
import model.RegistFreelancer;
import model.TaskList;

/**
 * FXML Controller class
 *
 * @author LAPR2-2020-G038
 */
public class CreateTaskUI implements Initializable {

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
    CreateTaskController taskL = new CreateTaskController();
    TaskList_IO IOtask = new TaskList_IO();
    RegistFreelancer_IO IOfree = new RegistFreelancer_IO();
    RegistFreelancer Rfree = new RegistFreelancer();
    TaskList_IO IOTask = new TaskList_IO();
    RegistOfOrganization_IO IOorg = new RegistOfOrganization_IO();
    RegisterFreelancerUI regUI = new RegisterFreelancerUI();
    FacadeController f = new FacadeController();
     Platform p = new Platform();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegisterFreelancer.fxml"));
        Parent root = loader.load();
        RegisterFreelancerUI FreeUI = loader.getController();       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void Add(ActionEvent event) throws NotFoundException {  
     taskL.startProcessOfAddTask(IOorg.read().getOrganizationByEmailCollaborator(f.getFacade().getSessaoAtual().getEmailUtilizador()).getColab());
     taskL.addNewTask(Id.getText().trim(), briefDesc.getText().trim(), Integer.parseInt(timeDuration.getText().trim()),Double.parseDouble(costPerHour.getText().trim()) , taskCategory.getText().trim());
     System.out.println(IOfree.read());
     taskL.getTask().setFreelancer(IOfree.read().getFreelancerbyName(Freelancer.getText().trim()));
        System.out.println(taskL.getTask());
        System.out.println(taskL.getTask());
      IOtask.write(taskL.getTl());
     
    }
    public FacadeController GetFacade() {
        return f;
    }
  

   public void associate(RegisterFreelancerUI regUI) {
       this.regUI = regUI;
       f = regUI.GetFacade();
       System.out.println(f.getFacade().getSessaoAtual().getEmailUtilizador());
       
    }
}
