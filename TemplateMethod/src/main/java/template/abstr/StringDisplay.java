package template.abstr;

public class StringDisplay extends AbstractDisplay {

    private final String string;
    private final int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    protected void open() {
        this.printLine();

    }

    @Override
    protected void print() {
        System.out.printf("|%s|\n", string);
    }

    @Override
    protected void close() {
        this.printLine();
    }

    public void printLine() {
        System.out.print("+");

        for(int i=0; i<width; i++) {
            System.out.print("-");
        }

        System.out.println("+");
    }

}
