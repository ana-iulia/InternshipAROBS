package week1.lab4.exercise1;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = radius = 1.0;
        this.color = color = "red";
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

}

class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius() + " " + circle.getArea());

        Circle circle1 = new Circle(3.5);
        System.out.println(circle1.getRadius() + " " + circle1.getArea());

    }
}
