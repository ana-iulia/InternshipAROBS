package lab5.exercise4;

public abstract class Sensor {
    private String location;

    public abstract int readValue();

    public String getLocation() {
        return this.location;
    }


}