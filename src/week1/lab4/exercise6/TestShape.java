package week1.lab4.exercise6;

public class TestShape {
    public static void main(String[] args){
        Shape shape=new Shape();
        System.out.println(shape);
        Circle circle=new Circle();
        System.out.println(circle);
        circle.setRadius(2.0);
        System.out.println(circle);
        System.out.println(circle.getArea()+" "+circle.getPerimeter());
        Rectangle rectangle=new Rectangle();
        System.out.println(rectangle);
        rectangle.setColor("blue");
        rectangle.setFilled(false);
        rectangle.setLength(4.0);
        rectangle.setWidth(3.0);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea()+" "+rectangle.getPerimeter());
        Square square=new Square(2.0);
        System.out.println(square);
        System.out.println(square.getArea()+" "+square.getPerimeter());
        square.setSide(5.0);
        System.out.println(square);
        System.out.println(square.getArea()+" "+square.getPerimeter());


    }
}
