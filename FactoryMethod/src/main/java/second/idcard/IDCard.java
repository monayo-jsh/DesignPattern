package second.idcard;

import second.framwork.Product;

public class IDCard extends Product {

    private final String owner;

    public IDCard(String owner) {
        System.out.println(owner + "의 ID카드를 생성합니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return String.format("[IDCard: %s]", owner);
    }

    public String getOwner() {
        return owner;
    }
}
