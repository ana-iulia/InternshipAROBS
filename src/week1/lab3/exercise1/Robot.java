package week1.lab3.exercise1;

public class Robot {
    private int x;

    public Robot() {
        this.x = 1;
    }
    public void change(int k){
        if(k>=1){
            this.x+=k;
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                '}';
    }

}

class TestRobot{
        public static void main(String[] args){
            Robot robot=new Robot();
            System.out.println(robot);

            robot.change(9);
            System.out.println(robot);

            robot.change(-3);
            System.out.println(robot);
        }
}
