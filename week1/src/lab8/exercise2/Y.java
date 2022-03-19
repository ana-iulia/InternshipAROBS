package lab8.exercise2;

public class Y extends Z implements A {

    @Override
    public void met1() {
        System.out.println("met1");
    }


    public void met3(X o) {
        System.out.println("met 2" + o.p);
    }
}
