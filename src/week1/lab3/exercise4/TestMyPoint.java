package week1.lab3.exercise4;

class TestMyPoint {
    public static void main(String[] args) {
        MyPoint myPoint = new MyPoint();
        System.out.println("myPoint: " + myPoint);
        myPoint.setX(2);
        myPoint.setY(3);
        System.out.println("myPoint: " + myPoint);
        MyPoint anotherPoint = new MyPoint(3, 5);
        System.out.println("anotherPoint: " + anotherPoint);
        anotherPoint.setXY(4, 6);
        System.out.println("anotherPoint: " + anotherPoint);
        System.out.println("distance1: " + myPoint.distance(anotherPoint));
        System.out.println("distance2: " + anotherPoint.distance(3, 7));
    }
}