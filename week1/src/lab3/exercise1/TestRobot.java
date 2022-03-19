package lab3.exercise1;

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

