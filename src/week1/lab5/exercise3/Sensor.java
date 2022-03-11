package week1.lab5.exercise3;

public abstract class Sensor {
    private String location;

    public abstract int readValue();

    public String getLocation() {
        return this.location;
    }


}
