package lab10.exercise4;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private final Robot[][] matrix = new Robot[100][100];
    private final List<Robot> robots = new ArrayList<>();

    public GameRepository() {
        initializeMatrix();
    }

    public synchronized List<Robot> getRobots() {
        return robots;
    }

    public synchronized void addRobot(Robot robot) {
        this.robots.add(robot);
    }

    private void initializeMatrix() {

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                this.matrix[i][j] = null;
            }
        }
    }

    public synchronized Robot[][] getMatrix() {
        return matrix;
    }

    public synchronized boolean move(Robot robot, Move move) {
        if (this.matrix[move.getLine()][move.getColumn()] != null) {
            Robot robotToRemove = this.matrix[move.getLine()][move.getColumn()];
            System.out.println("Deleted " + robotToRemove + " position: " + robotToRemove.getPosition() + " and " + robot + "position: " + move + " size: " + robots.size());
            if (robot.getPosition().getLine() != -1 && robot.getPosition().getColumn() != -1) {
                freeMove(new Move(robot.getPosition().getColumn(), robot.getPosition().getColumn()));
            }
            robots.remove(robotToRemove);
            robotToRemove.stopRunning();
            robots.remove(robot);
            robot.stopRunning();

            return false;
        } else {
            this.matrix[move.getLine()][move.getColumn()] = robot;
            if (robot.getPosition().getLine() != -1 && robot.getPosition().getColumn() != -1) {
                freeMove(new Move(robot.getPosition().getColumn(), robot.getPosition().getColumn()));
            }
            return true;
        }

    }

    public synchronized void freeMove(Move move) {
        this.matrix[move.getLine()][move.getColumn()] = null;

    }
}
