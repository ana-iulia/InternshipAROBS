package week1.lab4.exercise5;

import week1.lab3.exercise2.Circle;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double radius) {
        super(radius);
        height = 1.0;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return 2 * Math.PI * this.getRadius() * this.getHeight() + 2 * Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double getVolume() {
        return Math.PI * Math.pow(this.getRadius(), 2) * this.getHeight();
    }
}

class TestCylinder {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);
        System.out.println(circle.getArea());
        Cylinder cylinder = new Cylinder();
        Cylinder cylinder2 = new Cylinder(2.5);
        Cylinder cylinder3 = new Cylinder(1.5, 3);
        System.out.println(cylinder.getArea() + " " + cylinder.getVolume());
        System.out.println(cylinder2.getArea() + " " + cylinder2.getVolume());
        System.out.println(cylinder3.getArea() + " " + cylinder3.getVolume());

    }
}