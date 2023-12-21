public class Printer implements Printable {

    private String name;

    public Printer() {
        heavyJob("Printer 인스턴스 생성 중 ");
    }
    public Printer(String name) {
        this.name = name;
        heavyJob("Printer 인스턴스(" + name + ") 생성 중 ");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    //무거운 작업이라고 가정
    public void heavyJob(String msg) {
        System.out.print(msg);
        for(int i=0; i<5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}

            System.out.print(".");
        }
        System.out.println(" 완료");
    }
}
