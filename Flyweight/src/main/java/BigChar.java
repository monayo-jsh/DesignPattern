import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {

    private final char charName; //문자 이름
    private final String fontData; //문자를 표현하는 문자열 ('#', '.', '\n'으로 이루어진 열)

    public BigChar(char charName) {
        this.charName = charName;

        String fontData;
        try {
            String filename = String.format("big%s.txt", charName);
            String filePath = "file" + File.separator + filename;
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filePath))) {
                sb.append(line);
                sb.append("\n");
            }
            fontData = sb.toString();
        } catch (IOException e) {
            fontData = charName + "?";
        }

        this.fontData = fontData;
    }

    public void print() {
        System.out.print(fontData);
    }

}
