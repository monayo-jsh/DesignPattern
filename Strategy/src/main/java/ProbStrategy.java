import java.util.Random;

public class ProbStrategy implements Strategy {

    private final Random random;
    private Hand prevHand;
    private Hand currHand;
    private final int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        this.random = new Random(seed);
        this.prevHand = Hand.ROCK;
        this.currHand = Hand.ROCK;
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currHand.getHandValue()));
        int handValue = 0;

        if (bet < history[currHand.getHandValue()][0]) {
            handValue = 0;
        } else if (bet < history[currHand.getHandValue()][0] + history[currHand.getHandValue()][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }

        prevHand = currHand;
        currHand = Hand.getHand(handValue);
        return currHand;
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i=0; i<3; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHand.getHandValue()][currHand.getHandValue()]++;
            return;
        }

        history[prevHand.getHandValue()][(currHand.getHandValue() + 1) % 3]++;
        history[prevHand.getHandValue()][(currHand.getHandValue() + 2) % 3]++;
    }

}
