package WEEK1.DesignPattern.ProxyPatternExample;

public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else {
            System.out.println("Image already loaded, using cache: " + fileName);
        }

        realImage.display();
    }
}