package second.framework;

public class CopyCreatorMessageBox implements CopyProduct {

    private final char decochar;

    public CopyCreatorMessageBox(char decochar) {
        this.decochar = decochar;
    }

    public CopyCreatorMessageBox(CopyCreatorMessageBox copyCreatorMessageBox) {
        this.decochar = copyCreatorMessageBox.decochar;
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

    @Override
    public CopyProduct createCopy() {
        return new CopyCreatorMessageBox(this);
    }
}
