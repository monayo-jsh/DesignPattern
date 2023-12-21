public class Application {

    public static void main(String[] args) {

        Printable printable = new PrinterProxy("Alice", "Printer");

        System.out.println("이름은 현재 " + printable.getPrinterName() + " 입니다.");

        printable.setPrinterName("Bob");

        System.out.println("이름은 현재 " + printable.getPrinterName() + " 입니다.");

        printable.print("Hello, world.");

        System.out.println();

        Printable realPrinter = new Printer("Charlie");

        System.out.println("이름은 현재 " + realPrinter.getPrinterName() + " 입니다.");

        realPrinter.print("Hello, world.");
    }

}
