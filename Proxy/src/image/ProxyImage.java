package image;

import javafx.scene.image.Image;

public class ProxyImage implements IImage{
	private final String filename;
    private final Image proxyImage;
    private RealImage img;
    
    /**
     * Constructor
     * @param filename
     */
    public ProxyImage(String filename) {
        this.proxyImage = new Image("proxy"+filename);
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    public Image displayImage() {
        if (img == null) {
           img = new RealImage(filename);
        }
        return img.showData();
    }

	@Override
	public Image showData() {
		System.out.println("proxy"+filename);
		return proxyImage;
	}
    
    
}
