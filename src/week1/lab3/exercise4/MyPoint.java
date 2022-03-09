package week1.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(this.x - another.getX(), 2) + Math.pow(this.y - another.getY(), 2));
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}


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