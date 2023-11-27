public class Application extends Thread {

    public static void main(String[] args) throws ClassNotFoundException {

        //생성자 private
        //Singleton singleton = new Singleton();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.printf("s1[%s] == s2[%s] : %s", s1, s2, s1 == s2);

        System.out.println();

        EnumSingleton es1 = EnumSingleton.INSTANCE;
        EnumSingleton es2 = EnumSingleton.INSTANCE;

        System.out.printf("es1[%s] == es2[%s] : %s", es1, es2, es1 == es2);

        System.out.println();

        es1.hello();

        TicketMaker t1 = TicketMaker.getInstance();

        System.out.println(t1.getNextTicketNumber());
        System.out.println(t1.getNextTicketNumber());
        System.out.println(t1.getNextTicketNumber());

        System.out.println();

        TicketMaker t2 = TicketMaker.getInstance();

        System.out.println(t2.getNextTicketNumber());
        System.out.println(t2.getNextTicketNumber());
        System.out.println(t2.getNextTicketNumber());

        System.out.println();

        Triple a = Triple.getInstance("ALPHA");
        System.out.println(a.name());

        Triple b = Triple.getInstance("BETA");
        System.out.println(b.name());

        Triple c = Triple.getInstance("GAMMA");
        System.out.println(c.name());

        System.out.println();

        new Application().start();
        new Application().start();
        new Application().start();
    }

    @Override
    public void run() {
        LazySigleton lazySingleton = LazySigleton.getInstance();
        System.out.println("lazySingleton = " + lazySingleton);
    }
}
