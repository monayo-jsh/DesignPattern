package second;

import second.framework.Product;

public class MessageBox extends Product {

    private final char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int decoLength = 1 + s.length() + 1;

        printLine(decoLength);
        System.out.println(decochar + s + decochar);
        printLine(decoLength);
    }

    private void printLine(int length) {
        for (int i=0; i<length; i++) {
            System.out.print(decochar);
        }
        System.out.println();
    }

}
