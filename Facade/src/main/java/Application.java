public class Application {

    public static void main(String[] args) {
        SubSystemFacade subSystemFacade = new SubSystemFacade(new SubSystemOne(), new SubSystemTwo(), new SubSystemThree(), new SubSystemFour());

        System.out.println("=================");

        subSystemFacade.methodA();

        System.out.println("=================");

        subSystemFacade.methodB();

    }

}
