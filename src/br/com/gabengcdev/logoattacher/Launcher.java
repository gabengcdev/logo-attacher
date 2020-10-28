package br.com.gabengcdev.logoattacher;

import br.com.gabengcdev.logoattacher.view.LogoMain;
import br.com.gabengcdev.logoattacher.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		ViewFactory viewFactory = new ViewFactory(new LogoMain());
		
		viewFactory.showMainWindow();
		
//		Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
//		
//		Scene scene = new Scene(parent);
//		stage.setScene(scene);
//		stage.setTitle("Logo Attacher");
//		stage.setResizable(false);
//		stage.show();
		
	}
	
}
