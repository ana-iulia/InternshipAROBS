package lab5.exercise2;

public class TestImage {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("test", false);
        RealImage realImage=new RealImage("test2");
        realImage.rotatedImage();
        proxyImage.rotatedImage();
        realImage.display();
        proxyImage.display();


    }
}
