package WEEK1.DesignPattern.ProxyPatternExample;

public class ProxyPatternTest {

    public static void main(String[] args) {

        Image img = new ProxyImage("landscape_photo.jpg");

        System.out.println("First time image display:");
        img.display();

        System.out.println();

        System.out.println("Second time image display:");
        img.display();
    }
}