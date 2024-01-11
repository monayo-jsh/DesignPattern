package second;

public class PrintBannerExtends extends Banner implements Print {
    public PrintBannerExtends(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
