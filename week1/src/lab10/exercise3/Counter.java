package lab10.exercise3;

public class Counter extends Thread {
    private int minCount;
    private int maxCount;
    private Thread t;

    public Counter(int minCount, int maxCount, Thread t) {
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.t = t;
    }


    public void run() {
        System.out.println("Firul " + getName() + " a intrat in metoda run()");
        try {
            if (t != null) t.join();
            for (int i = this.minCount; i <= this.maxCount; i++) {
                System.out.println(getName() + ": " + i);
            }

            System.out.println("Firul " + getName() + " a terminat operatia.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}