package br.com.gabengcdev.logoattacher.controller;

import br.com.gabengcdev.logoattacher.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WorkDoneController extends BaseController {
	
	
	@FXML
	private Label photosAdded;
	
	@FXML
	void noChoice() {

	}

	@FXML
	void yesChoice() {

	}

	public WorkDoneController(ViewFactory viewFactory, String fxmlName) {
		super(viewFactory, fxmlName);
	}
	
	public void photosSetter(String what) {
		photosAdded.setText(what);
	}
	
}
