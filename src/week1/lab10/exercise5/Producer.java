package week1.lab10.exercise5;

/**
 * Aceasta este o clasa de tip fir de executie. In cadrul unei bucle infinite sunt
 * generate numere de tip double si sunt adaugate in cadrul unui obiect de tip Buffer
 * apeland metoda put. Aduagare elementelor se face la intervale de 1 secunda.
 */
class Producer implements Runnable {
    private Buffer bf;
    private Thread thread;

    Producer(Buffer bf) {
        this.bf = bf;
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {
        while (true) {
            bf.push(Math.random());
            System.out.println("Am scris.");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}