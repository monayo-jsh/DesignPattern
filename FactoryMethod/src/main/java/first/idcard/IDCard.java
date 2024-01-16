package first.idcard;

import first.framework.Product;

public class IDCard extends Product {

    private final int serial;
    private final String owner;

    IDCard(String owner, int serial) {
        System.out.println(String.format("%s의 카드를 %s번으로 생성.", owner, serial));
        this.serial = serial;
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return String.format("[IDCard: %s, Serial: %s]", this.owner, this.serial);
    }
}
