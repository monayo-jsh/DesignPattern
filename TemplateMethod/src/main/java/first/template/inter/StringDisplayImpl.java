package first.template.inter;

public class StringDisplayImpl implements InterfaceDisplay {

    private final String string;
    private final int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        this.printLine();

    }

    @Override
    public void print() {
        System.out.printf("|%s|%n", string);
    }

    @Override
    public void close() {
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
