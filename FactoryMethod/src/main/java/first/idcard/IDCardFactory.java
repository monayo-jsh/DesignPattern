package first.idcard;

import first.framework.Factory;
import first.framework.Product;

import java.util.concurrent.atomic.AtomicInteger;

public class IDCardFactory extends Factory {

    private final AtomicInteger serial = new AtomicInteger(100);

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial.getAndIncrement());
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(String.format("%s을 등록했습니다.", product));
    }

}
