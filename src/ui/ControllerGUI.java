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
    	
    	if(line != "") {
    		
    		String [] countries = line.split("\n");
    		
    		for(int i = 0; i < countries.length; i++) {
    			
    			String [] data = countries[i].split(";");
    			
    			int mGold = Integer.parseInt(data[1]);
    			int mSilver = Integer.parseInt(data[2]);
    			int mBronze = Integer.parseInt(data[3]);
    			int fGold = Integer.parseInt(data[4]);
    			int fSilver = Integer.parseInt(data[5]);
    			int fBronze = Integer.parseInt(data[6]);
    			
    			Country c = new Country(data[0], mGold, mSilver, mBronze, fGold, fSilver, fBronze);
    			
    			manager.addCountry(c);
    		}
    	}
    	
    	sortAll();
    }
    
    @FXML
    void importData(ActionEvent event) throws IOException {
    	
//    	manager.importData();
    	System.out.println(manager.listToText(manager.importData()));
    	
    	taInput.setText(manager.listToText(manager.importData()));
    }
    
    public void showSuccessDialogue(String header, String message) {

    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Billboards Manager");
    	alert.setHeaderText(header);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
    
    public void sortAll() {
    	
    	String result = "";
    	
    	manager.sortByMalePodiumAndName();
    	
    	result += "===COMPARATOR CLASS===\n" + 
    			"MALE\n";
    	result += manager.printMaleAndName();
    	result += "----------\n\n";
    	
//    	System.out.println(manager.printMaleAndName());
    	
    	manager.sortByFemalePodiumAndName();
    	
    	result += "===COMPARATOR INTERFACE===\n" + 
    			"FEMALE\n";
    	result += manager.printFemaleAndName();
    	result += "----------\n\n";
    	
    	result += "===SELECTION SORT===\n";
    	manager.sortBySelectionSort();
    	result += manager.printTotals();
    	result += "----------\n\n";
    	
    	result += "===INSERTION SORT===\n";
    	manager.sortByInsertionSort();
    	result += manager.printTotals();
    	result += "----------\n\n";
    	
    	
    	taResults.setText(result);
    	
    	manager.removeAllCountries();
    }
}
