package br.com.gabengcdev.logoattacher.controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainWindowController {

	   @FXML
	    private TextField photosAddressField;

	    @FXML
	    private TextField logoAddressField;

	    @FXML
	    void mergeLogoIntoPhotos() {
	    	//ActionEvent event was inside mergeLogoIntoPhotos()
	    	System.out.println("Clicked");
	    }
	    
	    @FXML
	    void searchLogo() {
	    	System.out.println("Logo Clicked");
	    }

	    @FXML
	    void searchPhotos() {
	    	System.out.println("Photos Clicked");
	    }

	    
	
}
