public class Player {

    private final String name;
    private final Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return strategy.nextHand();
    }
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }
    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return String.format("[%s - gameCount: %d, winCount: %d, loseCount: %d]", name, gameCount, winCount, loseCount);
    }
}
