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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable {

	private static String logoSrc;
	private static String destinyFolder;
	private static ArrayList<String> photosList = new ArrayList<String>();
	private static int indexer = 1;
	private static int photosCounter = 1;
	@FXML
	private TextField logoAddressField;

	@FXML
	private TextField photosAddressField;

	@FXML
	private TextField destinyField;

	@FXML
	private Button btnSearchLogo;

	@FXML
	private Button btnSearchPhotos;

	@FXML
	void mergeLogoIntoPhotos() {
		
		for (String image : photosList) {
			File sourceImageFile = new File(image);
			File watermarkImageFile = new File(logoSrc);
			File destImageFile = new File(destinyFolder+"/"+indexer+".png");
			addImageWatermark(sourceImageFile, watermarkImageFile, destImageFile);
			indexer+=1;
			photosCounter+=1;
		}
		System.out.println("O logo foi adicionado em "+photosCounter+" fotos com sucesso!");
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

	@FXML
	void defineDestiny() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
			destinyField.setText(selectedDirectory.getAbsolutePath());
			// destinyFolder = selectedDirectory.getAbsolutePath();
			System.out.println(destinyFolder);
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
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
			g2d.setComposite(alphaChannel);

			// calculates the coordinate where the image is painted
			int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
			int topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;

			// paints the image watermark
			g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);

			ImageIO.write(sourceImage,"png", destImageFile);
			g2d.dispose();


		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

}
