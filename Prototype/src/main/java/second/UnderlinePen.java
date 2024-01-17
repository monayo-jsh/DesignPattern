package second;

import second.framework.Product;

public class UnderlinePen extends Product {

    private final char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int decoLength = s.length();

        System.out.println(s);
        printLine(decoLength);
    }

    private void printLine(int length) {
        for (int i=0; i<length; i++) {
            System.out.print(ulchar);
        }
        System.out.println();
    }

}
