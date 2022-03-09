package week1.lab3.exercise5;

public class Flower {
    private int petal;
    private static int number = 0;

    Flower() {
        addFlowerNumber();
        System.out.println("Flower number " + number + " has been created!");
    }

    private static void addFlowerNumber() {
        number++;
    }

    public static void main(String[] args) {
        Flower[] garden = new Flower[5];
        for (int i = 0; i < 5; i++) {
            Flower f = new Flower();
            garden[i] = f;
        }
    }
}