import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDisplayImpl extends DisplayImpl {

    private final String fileName;

    public FileDisplayImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void rawOpen() {
        System.out.println("=-=-=-=-=-= " + fileName + " =-=-=-=-=-=");
    }

    @Override
    public void rawPrint() {
        try {
            for (String line : Files.readAllLines(Path.of(fileName))) {
                System.out.printf("> %s%n", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-=");
    }
}
