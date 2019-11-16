package main;

import image.IImage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ImageViewController {
	
	@FXML
	ImageView realImage;

	public void showRealImage(IImage proxyImage) {
		realImage.setImage(proxyImage.displayImage());		
	}
	

}
