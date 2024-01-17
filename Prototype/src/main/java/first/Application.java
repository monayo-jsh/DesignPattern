package first;

import first.framework.*;

public class Application {

    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.register("strong message", new UnderlinePen('-'));
        manager.register("warning box", new MessageBox('*'));
        manager.register("slash box", new MessageBox('/'));

        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        System.out.println();

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        System.out.println();

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");

        System.out.println();

        CopyManager copyManager = new CopyManager();
        copyManager.register("ampersand box", new CopyCreatorMessageBox('&'));
        copyManager.register("percent box", new CopyCreatorMessageBox('%'));

        CopyProduct p4 = copyManager.create("ampersand box");
        p4.use("Hello, world.");

        System.out.println();

        CopyProduct p5 = copyManager.create("percent box");
        p5.use("Hello, world.");
    }

}
