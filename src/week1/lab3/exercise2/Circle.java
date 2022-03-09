package week1.lab3.exercise2;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this.radius = radius = 1.0;
        this.color = color = "red";
    }

    public Circle(double radius) {
        this.radius= radius;
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
        System.out.println(circle.getRadius());

        circle = new Circle(2.5);
        System.out.println(circle.getArea());

    }
}
