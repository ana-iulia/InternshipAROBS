package week1.lab10.exercise5;

/**
 * Aceasta este o clasa de tip fir de executie. Intr-o bucla infinita sunt citite elemente
 * din cadrul unui obiect de tip Buffer.
 */

class Consumer extends Thread {
    private Buffer bf;

    Consumer(Buffer bf) {
        this.bf = bf;
    }

    public void run() {
        while (true) {
            System.out.println("Am citit : " + this + " >> " + bf.get());
        }
    }
}