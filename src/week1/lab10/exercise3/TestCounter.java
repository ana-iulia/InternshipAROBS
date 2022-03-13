package week1.lab10.exercise3;

public class TestCounter {
    public static void main(String[] args) {
        Counter w1 = new Counter(0, 100, null);
        Counter w2 = new Counter(100, 200,  w1);
        w1.start();
        w2.start();
    }
}
