package lab3.exercise2;

class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());

        circle = new Circle(2.5);
        System.out.println(circle.getArea());

    }
}