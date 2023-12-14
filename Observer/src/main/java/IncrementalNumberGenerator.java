public class IncrementalNumberGenerator extends NumberGenerator {

    private final int startNumber;
    private final int endNumber;
    private final int stepNumber;

    private int number;

    public IncrementalNumberGenerator(int startNumber, int endNumber, int stepNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.stepNumber = stepNumber;
    }

    @Override
    protected int getNumber() {
        return number;
    }

    @Override
    protected void execute() {
        for (int i = startNumber; i < endNumber; i+=stepNumber) {
            number = i;
            notifyObservers();
        }
    }
}
