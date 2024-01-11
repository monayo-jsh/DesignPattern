package second;

import java.io.IOException;
import second.example.FileIO;
import second.example.FileProperties;

public class SecondApplication {

    public static void main(String[] args) {

        Banner banner = new Banner("Hello");
        banner.showWithParen();
        banner.showWithAster();

        System.out.println();

        Print printBannerExtends = new PrintBannerExtends("Hello");
        printBannerExtends.printWeak();
        printBannerExtends.printStrong();

        System.out.println();

        Print printBannerDelegate = new PrintBannerDelegate("Hello");
        printBannerDelegate.printWeak();
        printBannerDelegate.printStrong();

        example();
    }

    private static void example() {

        FileIO fileIO = new FileProperties();

        try {
            fileIO.readFromFile("file.txt");
            fileIO.setValue("width", "1024");
            fileIO.setValue("height", "512");
            fileIO.setValue("depth", "32");
            fileIO.writeToFile("secondFile.txt");
            System.out.println("secondFile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
