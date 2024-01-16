package second.idcard;

import java.util.concurrent.atomic.AtomicInteger;
import second.framwork.Factory;
import second.framwork.Product;

public class IDCardFactory extends Factory {

    private final AtomicInteger serialNumber = new AtomicInteger(100);

    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner, serialNumber.getAndIncrement());
    }

    @Override
    public void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
