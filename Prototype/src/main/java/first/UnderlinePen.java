package first;

import first.framework.Product;

public class UnderlinePen extends Product {

    private final char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    @Override
    public void use(String s) {
        System.out.println(s);
        printLine(s.length());
        System.out.println();
    }

    public void printLine(int decoLen) {
        for(int i=0; i<decoLen; i++) {
            System.out.print(this.ulChar);
        }
    }

}
