package lab7.exercise4;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String toString() {
        return model + ";" + price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
