package week1.lab5.exercise2;

public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName,boolean rotated) {
        this.fileName = fileName;
        if(rotated){
            RotatedImage();
        }
        else display();
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public void RotatedImage() {
        System.out.println("Display rotated " + this.fileName);

    }
}