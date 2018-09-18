/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facility;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.json.simple.JSONObject;

/**
 * FXML Controller class
 *
 * @author eisuranga
 */
public class Main_data_screenController implements Initializable {

    @FXML
    private ImageView mm;
    @FXML
    private TextField txtPoint;
    @FXML
    private TextField txtDuty1;
    @FXML
    private TextField txtDuty2;
    @FXML
    private TextField txtDuty3;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtLostFound;
    @FXML
    private TextField txtKeysIsuued;
    @FXML
    private TextField txtKeysReturned;
    @FXML
    private TextField txtSpecialEvents;
    @FXML
    private TextField txtTail;
    @FXML
    private TextField txtLaynyard;
    @FXML
    private TextField txtPhoto;
    @FXML
    private TextField txtFid;
    @FXML
    private TextField txtVisitors;
    @FXML
    private TextField txtServiceProvider;
    @FXML
    private TextField txtRestrictedItem;
    @FXML
    private TextField txtOther;
    @FXML
    private TextField txtAssetMovemer;
    @FXML
    private TextField txtWorkPermits;
    @FXML
    private TextField txtLeave;
    @FXML
    private TextField txtReport;
    @FXML
    private TextField txtVisi;
    @FXML
    private TextField txtNearMiss;
    @FXML
    private TextField txtAccidents;
    @FXML
    private TextField txtMedical;
    @FXML
    private TextField txtDoctorVisits;
    @FXML
    private TextField txtAmbulance;
    @FXML
    private TextField txtFireAlarm;
    @FXML
    private TextField txtEquipment;
    @FXML
    private TextField txtLight;
    @FXML
    private TextField txtOut;
    @FXML
    private TextField txtIn;
    @FXML
    private TextField txtCourier;
    @FXML
    private TextField txtLetters;
    @FXML
    private TextField txtGarbage;
    @FXML
    private TextField txtPatrolVisit;
    @FXML
    private TextField txtPerimeter;
    @FXML
    private TextField txtSuttle;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtTime;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
        Date date = new Date();
        String timeStamp = dateFormat.format(date);

        String hostname = null;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        txtFid.setText("0");
        txtLostFound.setText("0");
        txtKeysIsuued.setText("0");
        txtKeysReturned.setText("0");
        txtSpecialEvents.setText("0");
        txtTail.setText("0");
        txtLaynyard.setText("0");
        txtPhoto.setText("0");
        txtVisitors.setText("0");
        txtServiceProvider.setText("0");
        txtWorkPermits.setText("0");
        txtRestrictedItem.setText("0");
        txtOther.setText("0");
        txtAssetMovemer.setText("0");
        txtVisi.setText("0");
        txtNearMiss.setText("0");
        txtAccidents.setText("0");
        txtMedical.setText("0");
        txtDoctorVisits.setText("0");
        txtAmbulance.setText("0");
        txtFireAlarm.setText("0");
        txtEquipment.setText("0");
        txtLight.setText("0");
        txtOut.setText("0");
        txtIn.setText("0");
        txtCourier.setText("0");
        txtLetters.setText("0");
        txtGarbage.setText("0");
        txtPatrolVisit.setText("0");
        txtPerimeter.setText("0");
        txtSuttle.setText("0");
        txtTime.setText(timeStamp);
        txtReport.setText(System.getProperty("user.name"));
        txtPoint.setText(hostname);

    }

    @FXML
    String dataValidation(ActionEvent event) throws IOException {
        Window owner = btnSave.getScene().getWindow();
        JSONObject obj = new JSONObject();

        try {
            // checking valid integer using parseInt() method 
            obj.put("Point", txtPoint.getText());
            obj.put("duty1", txtDuty1.getText());
            obj.put("duty2", txtDuty2.getText());
            obj.put("duty3", txtDuty3.getText());
            obj.put("LostFound", Integer.parseInt(txtLostFound.getText()));
            obj.put("KeysIsuued", Integer.parseInt(txtKeysIsuued.getText()));
            obj.put("KeysReturned", Integer.parseInt(txtKeysReturned.getText()));
            obj.put("SpecialEvents", Integer.parseInt(txtSpecialEvents.getText()));
            obj.put("Tail", Integer.parseInt(txtTail.getText()));
            obj.put("Laynyard", Integer.parseInt(txtLaynyard.getText()));
            obj.put("Photo", Integer.parseInt(txtPhoto.getText()));
            obj.put("Fid", Integer.parseInt(txtFid.getText()));
            obj.put("WorkPermits", Integer.parseInt(txtWorkPermits.getText()));
            obj.put("Visitors", Integer.parseInt(txtVisitors.getText()));
            obj.put("ServiceProvider", Integer.parseInt(txtServiceProvider.getText()));
            obj.put("RestrictedItem", Integer.parseInt(txtRestrictedItem.getText()));
            obj.put("Other", Integer.parseInt(txtOther.getText()));
            obj.put("AssetMovemer", Integer.parseInt(txtAssetMovemer.getText()));
            obj.put("Report", txtReport.getText());
            obj.put("Leave", txtLeave.getText());
            obj.put("Visi", Integer.parseInt(txtVisi.getText()));
            obj.put("NearMiss", Integer.parseInt(txtNearMiss.getText()));
            obj.put("Accidents", Integer.parseInt(txtAccidents.getText()));
            obj.put("Medical", Integer.parseInt(txtMedical.getText()));
            obj.put("DoctorVisits", Integer.parseInt(txtDoctorVisits.getText()));
            obj.put("Ambulance", Integer.parseInt(txtAmbulance.getText()));
            obj.put("FireAlarm", Integer.parseInt(txtFireAlarm.getText()));
            obj.put("Equipment", Integer.parseInt(txtEquipment.getText()));
            obj.put("Light", Integer.parseInt(txtLight.getText()));
            obj.put("Out", Integer.parseInt(txtOut.getText()));
            obj.put("In", Integer.parseInt(txtIn.getText()));
            obj.put("Courier", Integer.parseInt(txtCourier.getText()));
            obj.put("Letters", Integer.parseInt(txtLetters.getText()));
            obj.put("Garbage", Integer.parseInt(txtGarbage.getText()));
            obj.put("PatrolVisit", Integer.parseInt(txtPatrolVisit.getText()));
            obj.put("Perimeter", Integer.parseInt(txtPerimeter.getText()));
            obj.put("Suttle", Integer.parseInt(txtSuttle.getText()));
            obj.put("Time", txtTime.getText());
            obj.put("Report", txtReport.getText());

            Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
            System.out.println(obj);
//            RestController rest = new RestController();
            RestController rest = new RestController();
            String response = rest.executeOrientDBFunction(obj.toString());
//        JSONObject responseObj = new JSONObject(response);
            System.out.println(response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Number");
//            return;
        }
        return null;
    }

    @FXML
    private void txtUnestrictedVisi(ActionEvent event) {
    }

    @FXML
    void closeWindow(MouseEvent event) {
    }

    @FXML
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}
