package first;

import first.framework.Factory;
import first.framework.Product;
import first.idcard.IDCardFactory;

public class Application {

    public static void main(String[] args) {

        Factory factory = new IDCardFactory();
        Product jsh = factory.create("JSH");
        Product ksk = factory.create("KSK");
        Product pjy = factory.create("PJY");

        //패키지 외부에서 new 생성 불가 -> IDCardFactory 를 통해서 IDCard 생성하도록 강제
        //접근제어자를 작성하지 않았을 경우 생성자, 메소드 등은 같은 패키지 안의 클래스만 이용 가능
        //생성 불가
        //new IDCard("NEW CARD", 100);

        System.out.println();

        jsh.use();
        ksk.use();
        pjy.use();

    }

}
