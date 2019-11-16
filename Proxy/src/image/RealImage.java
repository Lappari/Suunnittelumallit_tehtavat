package image;

import javafx.scene.image.Image;

public class RealImage implements IImage{
	private final String filename;
	private final Image realImage;

    /**
     * Constructor
     * @param filename
     */
    public RealImage(String filename) {
        this.filename = filename;
        this.realImage = new Image(filename);
    }

 	@Override
	public Image showData() {
 		System.out.println(filename);
		return realImage;
	}

	@Override
	public Image displayImage() {
		return realImage;
	}
}
