package lab5.exercise4;


import java.util.Random;

public class LightSensor extends Sensor {
    @Override
    public int readValue() {
        Random rand = new Random();
        return rand.nextInt(101);
    }
}
