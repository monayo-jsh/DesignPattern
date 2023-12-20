public class Application {

    public static void main(String[] args) {

        Runtime.getRuntime().gc();

        BigString bigString = new BigString("1212123");
        bigString.print();

        BigString bigStringNotShared = new BigString("1212123", false);
        bigStringNotShared.print();

        System.out.println("공유한 경우");
        usedShowMemory(true);
        System.out.println("공유하지 않은 경우");
        usedShowMemory(false);
    }

    private static void usedShowMemory(boolean shared) {
        BigString[] bigStrings = new BigString[10000];
        for (int i=0; i<bigStrings.length; i++) {
            bigStrings[i] = new BigString("1212123", shared);
        }
        showMemory();
    }

    private static void showMemory() {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("사용 메모리 = " + used);
    }

}
