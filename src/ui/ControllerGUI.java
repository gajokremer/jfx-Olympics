package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class ControllerGUI {
	
    @FXML
    private Pane mainPane;
    
    @FXML
    private TextArea taResults;
    
    @FXML
    private TextArea taInput;

    @FXML
	void startMenu() throws IOException {
		
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Menu.fxml"));
    	fxmlloader.setController(this);
    	Parent menu = fxmlloader.load();
    	mainPane.getChildren().setAll(menu);
	}
}
