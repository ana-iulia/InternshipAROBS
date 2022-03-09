package week1.lab5.exercise1;

import week1.lab4.exercise6.Shape;

import java.util.ArrayList;
import java.util.List;

public class TestShape {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        Circle circle = new Circle();
        shapeList.add(circle);
        circle.setRadius(2.0);
        Rectangle rectangle = new Rectangle();
        shapeList.add(rectangle);
        rectangle.setColor("blue");
        rectangle.setFilled(false);
        rectangle.setLength(4.0);
        rectangle.setWidth(3.0);
        Square square = new Square(2.0);
        shapeList.add(square);
        square.setSide(5.0);
        for (Shape s : shapeList) {
            System.out.println(s);
        }


    }
}
