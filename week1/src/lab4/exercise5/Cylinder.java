package lab4.exercise5;


import lab4.exercise1.Circle;

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

