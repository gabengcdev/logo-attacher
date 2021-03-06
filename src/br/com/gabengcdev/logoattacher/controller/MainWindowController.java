package br.com.gabengcdev.logoattacher.controller;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import br.com.gabengcdev.logoattacher.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainWindowController extends BaseController implements Initializable {

	public MainWindowController(ViewFactory viewFactory, String fxmlName) {
		super(viewFactory, fxmlName);
	}
	private static String logoSrc;
	private static String destinyFolder;
	private static ArrayList<String> photosList = new ArrayList<String>();
	private static int indexer = 1;
	public int photosCounter = 0;
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

		for (String image : photosList) {
			File sourceImageFile = new File(image);
			File watermarkImageFile = new File(logoSrc);
			File destImageFile = new File(destinyFolder + "/" + indexer + ".png");
			addImageWatermark(sourceImageFile, watermarkImageFile, destImageFile);
			indexer += 1;
			photosCounter += 1;
		}
		viewFactory.showWorkDoneWindow();

	}

	@FXML
	void searchLogo() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
		File f = fc.showOpenDialog(null);
		if (f != null) {
			logoAddressField.setText(f.getAbsolutePath());
			logoSrc = f.getAbsolutePath();
		}
	}

	@FXML
	void searchPhotos() {

		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
				new FileChooser.ExtensionFilter("PNG", "*.png"));
		List<File> f = fc.showOpenMultipleDialog(null);
		for (File file : f) {
			photosList.add(file.getAbsolutePath());
		}

		if (f != null) {
			photosAddressField.setText(f.get(0).getParent());
			destinyFolder = f.get(0).getParent();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rc) {

	}

	static void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {

		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
			g2d.setComposite(alphaChannel);
			g2d.drawImage(watermarkImage, 0, 0, sourceImage.getWidth(), sourceImage.getHeight(), null);
			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
