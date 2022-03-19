package lab4.exercise5;

import week1.lab3.exercise2.Circle;

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