public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println(getClass().getName() + " : " + generator.getNumber());

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
    }
}
