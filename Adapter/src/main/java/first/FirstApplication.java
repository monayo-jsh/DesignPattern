package first;

import first.example.FileIO;
import first.example.FileProperties;

public class FirstApplication {

    public static void main(String[] args) {
        study();
        example();
    }

    private static void study() {

        String string = "Hello";

        //기존 제공되는 기능
        Banner banner = new Banner(string);
        banner.showWithParen();
        banner.showWithAster();

        System.out.println();

        //adaptor 패턴 적용 (상속)
        Print print = new PrintBanner(string);
        print.printWeak();
        print.printStrong();

        System.out.println();

        //adaptor 패턴 적용 (위임)
        PrintBanner2 adaptor = new PrintBanner2(string);
        adaptor.printWeak();
        adaptor.printStrong();

        System.out.println();
    }

    private static void example() {

        FileIO f = new FileProperties();

        try {
            f.readFromFile("file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("newFile.txt");

            System.out.println("newFile.txt is created.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
