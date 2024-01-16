package second;

import second.framwork.Factory;
import second.framwork.Product;
import second.idcard.IDCardFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product product1 = factory.create("JSH");
        Product product2 = factory.create("HSY");
        Product product3 = factory.create("JJH");

        product1.use();
        product2.use();
        product3.use();
    }

}
