package main;

import java.io.IOException;
import image.IImage;
import image.ProxyImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MainViewController {

	private IImage image1, image2, image3, image4, image5, image6;
	private ImageViewController imgController;
	@FXML
	private ImageView imageOne, imageTwo, imageTree, imageFour, imageFive, imageSix;

	@FXML
	void initialize() {
		imgController = new ImageViewController();
		
		image1 = new ProxyImage("image1.jpg");
		image2 = new ProxyImage("image2.jpg");
		image3 = new ProxyImage("image3.jpg");
		image4 = new ProxyImage("image4.jpg");
		image5 = new ProxyImage("image5.jpg");
		image6 = new ProxyImage("image6.jpg");

		imageOne.setImage(image1.showData());
		imageTwo.setImage(image2.showData());
		imageTree.setImage(image3.showData());
		imageFour.setImage(image4.showData());
		imageFive.setImage(image5.showData());
		imageSix.setImage(image6.showData());

		imageOne.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image1);
		});

		imageTwo.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image2);
		});

		imageTree.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image3);
		});

		imageFour.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image4);
		});

		imageFive.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image5);
		});

		imageSix.setOnMouseClicked((MouseEvent event) -> {
			showRealImage(image6);
		});
	}

	private void showRealImage(IImage proxyImage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ImageView.fxml"));
			loader.setController(imgController);
			Scene scene = new Scene(loader.load());
			Stage stage = new Stage();
			stage.setTitle("ImageView");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imgController.showRealImage(proxyImage);
	}
	
}
