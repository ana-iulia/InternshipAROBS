package lab10.exercise5;

public class Test {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        Producer pro = new Producer(b);
        Consumer c = new Consumer(b);
        Consumer c2 = new Consumer(b);
        //Lanseaza cele 3 fire de executie. Se observa ca cele 3 fire de executie
        // folosesc in comun obiectul b de tip Buffer. Exista un fir pro ce este
        // responsabil cu adaugarea de elemente in buffer si doua obiecte
        // responsabile cu extragerea elementelor din buffer.
        pro.start();
        c.start();
        c2.start();
    }
}