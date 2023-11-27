import framework.Product;

public class MessageBox extends Product {

    private final char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String s) {
        int decoLen = 1 + s.length() + 1;
        printLine(decoLen);
        System.out.println();
        System.out.println(this.decoChar + s + this.decoChar);
        printLine(decoLen);
        System.out.println();
    }

    public void printLine(int decoLen) {
        for(int i=0; i<decoLen; i++) {
            System.out.print(this.decoChar);
        }
    }

}
