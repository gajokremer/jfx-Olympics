package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import model.Country;
import model.MedalManager;

public class ControllerGUI {
	
    @FXML
    private Pane mainPane;
    
    @FXML
    private TextArea taInput;
    
    @FXML
    private TextArea taResults;
    
    
    private MedalManager manager;

    public ControllerGUI () {

    	manager = new MedalManager();

    }
    
    @FXML
	void startMenu() throws IOException {
		
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Menu.fxml"));
    	fxmlloader.setController(this);
    	Parent menu = fxmlloader.load();
    	mainPane.getChildren().setAll(menu);
	}
    
    @FXML
    void organizeInfo(ActionEvent event) {

    	String line = taInput.getText();
    	
//    	String [] data = line.split(";");
//    	
//    	data[6].split("\n");
//    	
//    	Country c = new Country(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
//    	
//		if(manager.addCountry(c)) {
//			
//			String message = "";
//			String header = "";
//			showSuccessDialogue(header, message);
//			
//			System.out.println(c.toString());
//		}
//		
//		taInput.setText("");
//		taResults.setText(c.toString());
    	
    	String [] countries = line.split("\n");
    	
    	String result = "";
    	
    	for(int i = 0; i < countries.length; i++) {
    		
    		String [] data = countries[i].split(";");
    		
    		Country c = new Country(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
    		
    		System.out.println(c.toString());
    		
    		result += c.toString() + "\n";
    		
    		taResults.setText(result);
    	}
    }
    
    public void showSuccessDialogue(String header, String message) {

    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Billboards Manager");
    	alert.setHeaderText(header);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
}
