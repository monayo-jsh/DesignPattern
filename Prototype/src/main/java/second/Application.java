package second;

import second.framework.CopyCreatorMessageBox;
import second.framework.CopyManager;
import second.framework.CopyProduct;
import second.framework.Manager;
import second.framework.Product;

public class Application {

    public static void main(String[] args) {
        // 원본 생성
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 복사해서 사용
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world");

        // 원본 생성
        CopyManager copyManager = new CopyManager();
        copyManager.register("ampersand box", new CopyCreatorMessageBox('&'));
        copyManager.register("percent box", new CopyCreatorMessageBox('%'));

        // 복사해서 사용
        CopyProduct p4 = copyManager.create("ampersand box");
        p4.use("Hello, world.");

        System.out.println();

        CopyProduct p5 = copyManager.create("percent box");
        p5.use("Hello, world.");
    }

}
