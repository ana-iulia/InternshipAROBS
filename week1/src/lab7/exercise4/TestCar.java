package lab7.exercise4;

import week1.lab6.exercise4.Definition;
import week1.lab6.exercise4.Dictionary;
import week1.lab6.exercise4.Word;

import java.io.IOException;
import java.util.Scanner;

public class TestCar {

    public static void displayChoiceList() {
        System.out.println("""
                List of commands:
                1. Add car
                2. Show cars
                3. Find car by model
                4. Exit""");
    }

    public static void main(String[] args) {
        try {
            CarRepo carRepo = new CarRepo();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your choice:");
            displayChoiceList();
            while (true) {
                try {
                    while (true) {

                        System.out.println("Introduce command: ");
                        String choice = s.nextLine();
                        switch (choice) {
                            case "1":
                                System.out.println("Introduce name model of the car:");
                                String model = s.nextLine();
                                System.out.println("Introduce price of the car:");
                                double price = s.nextDouble();
                                Car car = new Car(model, price);
                                carRepo.addCar(car);
                                System.out.println("Car added!");
                                break;
                            case "2":
                                System.out.println("All cars:");
                                carRepo.getAllCars().forEach(System.out::println);
                                break;
                            case "3":
                                System.out.println("Introduce model:");
                                model = s.nextLine();
                                System.out.println(carRepo.findCar(model));
                                break;
                            case "4":
                                return;
                            case "exit":
                                return;
                            default:
                                System.out.println("Command doesn't exist!");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


