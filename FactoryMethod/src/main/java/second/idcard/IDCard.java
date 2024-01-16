package second.idcard;

import second.framwork.Product;

public class IDCard extends Product {

    private final String owner;
    private final int serialNumber;

    IDCard(String owner, int serialNumber) {
        System.out.println(owner + "[" + serialNumber+ "]의 ID카드를 생성합니다.");
        this.owner = owner;
        this.serialNumber = serialNumber;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return String.format("[IDCard: %s, SerialNumber: %d]", owner, serialNumber);
    }

    public String getOwner() {
        return owner;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
