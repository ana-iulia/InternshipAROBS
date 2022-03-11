package week1.lab5.exercise4;


import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private static Controller instance = null;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();

        return instance;
    }

    public void control() {

        LightSensor lightSensor = new LightSensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        Timer timer;
        long startTime = System.currentTimeMillis();
        System.out.println(java.time.LocalDateTime.now());
        int delay = 0;
        int period = 1000;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                System.out.println("Temeperature sensor: " + temperatureSensor.readValue());
                System.out.println("Light sensor: " + lightSensor.readValue());

                long currentTime = System.currentTimeMillis();
                if (currentTime - startTime >= 20000) {
                    timer.cancel();
                    System.out.println(java.time.LocalDateTime.now());
                }


            }

        }, delay, period);


    }
}
