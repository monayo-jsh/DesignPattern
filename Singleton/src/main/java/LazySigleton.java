public class LazySigleton {

    private static LazySigleton lazySigleton = null;

    private LazySigleton() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    public static synchronized LazySigleton getInstance() {
        if (lazySigleton == null) {
            lazySigleton = new LazySigleton();
        }

        return lazySigleton;
    }

}
