package lab4.exercise1;

class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius() + " " + circle.getArea());

        Circle circle1 = new Circle(3.5);
        System.out.println(circle1.getRadius() + " " + circle1.getArea());

    }
}
