import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        playRockPaperScissors();

        example();

    }

    private static void playRockPaperScissors() {
        Random random = new Random();

//        Player jsh = new Player("JSH", new WinningsStrategy(random.nextInt(1000)));
        Player jsh = new Player("JSH", new RandomStrategy(random.nextInt(1000)));
        Player ksk = new Player("KSK", new ProbStrategy(random.nextInt(1000)));
//        Player ksk = new Player("KSK", new RandomStrategy(random.nextInt(1000)));

        for(int i=0; i<10000; i++) {
            Hand jshNextHand = jsh.nextHand();
            Hand kskNextHand = ksk.nextHand();

            if (jshNextHand.isStrongerThan(kskNextHand)) {
                System.out.println("Winner: " + jsh);
                jsh.win();
                ksk.lose();
                continue;
            }

            if (kskNextHand.isStrongerThan(jshNextHand)) {
                System.out.println("Winner: " + ksk);
                jsh.lose();
                ksk.win();
                continue;
            }

            System.out.println("Even...");
            jsh.even();
            ksk.even();
        }

        System.out.println("--- Result ---");
        System.out.println(jsh);
        System.out.println(ksk);
    }

    private static void example() {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        //사전적으로 작은 순서
        list.sort(String::compareTo);
        System.out.println(list);

        //사전적으로 큰 순서
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
