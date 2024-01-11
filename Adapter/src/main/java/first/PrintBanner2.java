package first;

public class PrintBanner2 extends Print2 {

    private final Banner banner;

    public PrintBanner2(String string) {
        this.banner = new Banner(string);
    }

    @Override
    void printWeak() {
        this.banner.showWithParen();
    }

    @Override
    void printStrong() {
        this.banner.showWithAster();
    }
}
