package lab10.exercise5;

import java.util.ArrayList;

class Buffer {
    /*
     * Vector folosit pentru a inmagazina obiecte de tip Double.
     */
    ArrayList content = new ArrayList();

    /**
     * Prin intermediul acestei metode sunt adaugate elemente in containerul content.
     * Se observa ca aceasta metoda este sincronizata. Metoda fa fi apelata de firele
     * de executie de tip Producer.
     * <p>
     * Dupa adaugarea unui element in container se apeleaza metoda notify() aceasta asigura
     * trezirea unui fir de executie ce a fost blocat prin apelul functiei wait().
     *
     * @param d
     */
    synchronized void push(double d) {
        content.add(new Double(d));
        notify();
    }

    /**
     * Aceasta metoda este folosita pentru a extrage elemente din cadrul containerului
     * content. Se observa ca aceasta metoda este sincronizata.
     * Daca containerul este  gol se apeleaza metoda wait(). Aceasta va bloca firul
     * de executie apelant pana in momentul in care un fir de executie producator
     * va adauga in container un element si va apela metoda notify() (vezi metoda put(...))
     *
     * @return
     */
    synchronized double get() {
        double d = -1;
        try {
            while (content.size() == 0) wait();
            d = (((Double) content.get(0))).doubleValue();
            content.remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
}