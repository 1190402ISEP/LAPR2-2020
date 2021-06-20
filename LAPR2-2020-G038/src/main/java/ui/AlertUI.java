/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.scene.control.Alert;

/**
 *
 * @author LAPR2-2020-G038
 */
public class AlertUI {

    private static final String APP_TITTLE = "Generate Payments API";

    public static Alert createAlert(Alert.AlertType type, String header,String message) {

        Alert alerta = new Alert(type);
        alerta.setTitle(APP_TITTLE);
        alerta.setHeaderText(header);
        alerta.setContentText(message);

        return alerta;
    }
}
