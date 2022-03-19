package lab10.exercise4;

import java.io.IOException;

public class TestGame {
    public static void main(String[] args) {
        int numberOfThreads = 10;

        GameRepository repo = new GameRepository();

        Robot[] thread = new Robot[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            thread[i] = new Robot(repo);
            repo.addRobot(thread[i]);
        }
        for (int i = 0; i < numberOfThreads; i++) {
            thread[i].start();
        }

        while (repo.getRobots().size() > 1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Stopping the last thread...");
        for (int i = 0; i < numberOfThreads; i++) {
            thread[i].stopRunning();
        }

        try {
            for (int i = 0; i < numberOfThreads; i++) {
                thread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Winner: ");
        repo.getRobots().forEach(System.out::println);
        System.exit(0);
    }

}
