import java.util.Random;

public class WinningsStrategy implements Strategy {

    private final Random random;
    private boolean won;
    private Hand prevHand;

    public WinningsStrategy(int seed) {
        this.random = new Random(seed);
        this.won = false;
    }

    @Override
    public Hand nextHand() {
        if (this.won) {
            return prevHand;
        }

        prevHand = Hand.getHand(random.nextInt(3));
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        this.won = win;
    }
}
