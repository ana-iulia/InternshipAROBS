package week1.lab5.exercise2;

import java.util.ArrayList;
import java.util.List;

public class TestImage {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("test", false);
        RealImage realImage=new RealImage("test2");
        realImage.RotatedImage();
        proxyImage.RotatedImage();
        realImage.display();
        proxyImage.display();


    }
}
