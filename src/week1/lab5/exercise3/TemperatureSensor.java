package week1.lab5.exercise3;

import java.util.Random;

public class TemperatureSensor extends Sensor {
    @Override
    public int readValue() {
        Random rand = new Random();
        return rand.nextInt(101);
    }
}
