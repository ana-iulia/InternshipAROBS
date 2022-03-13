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

