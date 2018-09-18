/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import org.json.simple.JSONObject;

/**
 * FXML Controller class
 *
 * @author eisuranga
 */
public class RpaFormController {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private Button btnSubmt;
    
    public String name;
    public  int  age;

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }  
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        JSONObject obj = new JSONObject();
        name = txtName.getText();
        age =  Integer.parseInt(txtAge.getText());;

      obj.put("name", name);
      obj.put("Age", age);

      System.out.print(obj);

        Window owner = btnSubmt.getScene().getWindow();
        if(txtName.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your name");
            return;
        }
        if(txtAge.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your email id");
            return;
        }

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", 
                "Welcome " + txtName.getText());

    }

    @FXML
    private void handleSubmitButtonAction(MouseEvent event) {
    }

 
    
}
