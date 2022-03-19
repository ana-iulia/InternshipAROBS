package lab7.exercise4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepo {
    private FileReader fileReader;
    private FileWriter fileWriter;

    public CarRepo() throws IOException {
        this.fileReader = new FileReader("C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise4\\cars.dat");
        this.fileWriter = new FileWriter("C:\\Users\\anaiu\\GitHub\\InternshipAROBS\\src\\week1\\lab7\\exercise4\\cars.dat", true);


    }

    public void addCar(Car car) throws IOException {
        fileWriter.write(car.toString() + "\n");
        fileWriter.flush();
    }

    public List<Car> getAllCars() throws IOException {
        List<Car> cars = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(";");
            Car car = new Car(data[0], Double.parseDouble(data[1]));
            cars.add(car);
        }
        return cars;
    }

    public Car findCar(String model) throws IOException, ClassNotFoundException {
        List<Car> cars = getAllCars();
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }


}
