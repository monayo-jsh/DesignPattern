package second.template;

public class CharDisplay extends Display {

    private final char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(ch);
    }

    @Override
    protected void close() {
        System.out.print(">>");
    }
}
