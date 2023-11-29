public class Application {

    public static void main(String[] args) {

        Display d1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display d2 = new Display(new StringDisplayImpl("Hello, World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);

        RandomCountDisplay rd = new RandomCountDisplay(new StringDisplayImpl("Hi, JSH"));
        rd.randomDisplay(3);

        CountDisplay d4 = new CountDisplay(new FileDisplayImpl("star.txt"));
        d4.multiDisplay(3);

        IncreaseDisplay rd1 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        rd1.increaseDisplay(4);

        IncreaseDisplay rd2 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        rd2.increaseDisplay(6);
    }

}
