package br.com.gabengcdev.logoattacher.controller;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable {
		
	    @FXML
	    private TextField logoAddressField;
	
	    @FXML
	    private TextField photosAddressField;
	 	
		@FXML
		private Button btnSearchLogo;
		
	  	@FXML
	    private Button btnSearchPhotos;
	 
	    @FXML
	    void mergeLogoIntoPhotos() {
	    	System.out.println("Clicked");
	    }
	    
	    @FXML
	    void searchLogo() {
	    	FileChooser fc = new FileChooser();
	    	fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
	    	File f = fc.showOpenDialog(null);
	    	if(f != null) {
	    		logoAddressField.setText(f.getAbsolutePath());
	    	}
	    }

	    @FXML
	    void searchPhotos(ActionEvent event) {
	    	FileChooser fc = new FileChooser();
	    	fc.getExtensionFilters().addAll(
		    		new FileChooser.ExtensionFilter("All Images", "*.*"),
		    		new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		    		new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
		    		new FileChooser.ExtensionFilter("PNG", "*.png")
		    			);
	    	List<File> f = fc.showOpenMultipleDialog(null);
	    	for (File file : f) {
	    		System.out.println(file.getAbsolutePath());
	    	}
	    	
	    	if(f != null) {
					photosAddressField.setText(f.get(0).getParent());
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
		}

	
}
