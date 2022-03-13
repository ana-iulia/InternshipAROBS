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

