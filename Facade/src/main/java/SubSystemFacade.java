public class SubSystemFacade {

    private final SubSystemOne subSystemOne;
    private final SubSystemTwo subSystemTwo;
    private final SubSystemThree subSystemThree;
    private final SubSystemFour subSystemFour;

    public SubSystemFacade(SubSystemOne subSystemOne, SubSystemTwo subSystemTwo,
                           SubSystemThree subSystemThree, SubSystemFour subSystemFour) {
        this.subSystemOne = subSystemOne;
        this.subSystemTwo = subSystemTwo;
        this.subSystemThree = subSystemThree;
        this.subSystemFour = subSystemFour;
    }

    public void methodA() {
        System.out.println("SubSystemFacade.methodA()");

        subSystemOne.method();
        subSystemTwo.method();
        subSystemThree.method();
    }

    public void methodB() {
        System.out.println("SubSystemFacade.methodB()");

        subSystemTwo.method();
        subSystemFour.method();
    }
}
