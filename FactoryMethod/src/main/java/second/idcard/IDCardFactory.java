package second.idcard;

import second.framwork.Factory;
import second.framwork.Product;

public class IDCardFactory extends Factory {


    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    public void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
