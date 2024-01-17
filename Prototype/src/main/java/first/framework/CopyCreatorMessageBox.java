package first.framework;

public class CopyCreatorMessageBox implements CopyProduct {

    private final char decoChar;

    public CopyCreatorMessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    public CopyCreatorMessageBox(CopyCreatorMessageBox copyCreatorMessageBox) {
        this.decoChar = copyCreatorMessageBox.decoChar;
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

    @Override
    public CopyProduct createCopy() {
        return new CopyCreatorMessageBox(this);
    }

}
