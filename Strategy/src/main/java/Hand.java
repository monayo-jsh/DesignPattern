public enum Hand {
    ROCK("바위", 0), SCISSORS("가위", 1), PAPER("보", 2);

    private final String name;
    private final int handValue;

    Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return values()[handValue];
    }
    public int getHandValue() {
        return handValue;
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            //무승부
            return 0;
        }

        if ((handValue + 1) % 3 == hand.handValue) {
            //이기면
            return 1;
        }

        //지면
        return -1;
    }

    @Override
    public String toString() {
        return name;
    }
}
