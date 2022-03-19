package lab10.exercise4;

import java.util.Random;

public class Robot extends Thread {
    private Move position;
    private volatile boolean isRunning;
    private final GameRepository gameRepository;

    public Robot(GameRepository gameRepository) {
        this.isRunning = true;
        this.gameRepository = gameRepository;
        this.position = new Move(-1, -1);
    }

    public Move getPosition() {
        return position;
    }

    @Override
    public void run() {

        while (isRunning) {
            int line = generateNumber();
            int column = generateNumber();
            Move move = new Move(line, column);
            boolean moveMade = gameRepository.move(this, move);
            this.position.setColumn(column);
            this.position.setLine(line);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Robot{ " + getName() + " }";
    }

    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public void stopRunning() {
        this.isRunning = false;
    }
}
