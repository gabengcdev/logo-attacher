package br.com.gabengcdev.logoattacher.view;

import java.io.IOException;

import br.com.gabengcdev.logoattacher.controller.BaseController;
import br.com.gabengcdev.logoattacher.controller.MainWindowController;
import br.com.gabengcdev.logoattacher.controller.WorkDoneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
	
	private WorkDoneController wc;
	private LogoMain logoMain;

	public ViewFactory(LogoMain logoMain) {
		this.logoMain = logoMain;
	}

	public void showMainWindow() {

		System.out.println("showing main window");

		BaseController controller = new MainWindowController(this, "MainWindow.fxml");
		initializeStage(controller);
		//fx:controller="br.com.gabengcdev.logoattacher.controller.MainWindowController"
	}
	
	private void initializeStage (BaseController baseController) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
		fxmlLoader.setController(baseController);
		Parent parent;
		
		try {
			parent = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setTitle("Logo Attacher");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public void closeStage(Stage stageToClose) {
		stageToClose.close();
	}
	
	public void showWorkDoneWindow() {
		System.out.println("Work Done Window called");
		BaseController controller = new WorkDoneController(this, "WorkDone.fxml");
		initializeStage(controller);
		
	}
	
}
