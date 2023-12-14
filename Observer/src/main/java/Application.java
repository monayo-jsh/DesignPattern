public class Application {

    public static void main(String[] args) {

//        RandomNumberGenerator generator = new RandomNumberGenerator();

        IncrementalNumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);

        generator.addObserver(new DigitObserver());
        generator.addObserver(new GraphObserver());
        generator.addObserver(new FrameObserver());
        
        generator.execute();

    }

}
