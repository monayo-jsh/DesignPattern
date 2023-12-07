import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {

        example();

        test("src/main/java");
    }

    private static void test(String dirname) {

        try {
            MyFileVisitor visitor = new MyFileVisitor();
            Path root = Path.of(dirname);
            Files.walkFileTree(root, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void example() {
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));

        rootDir.accept(new ListVisitor());
        System.out.println();

        Directory jshDir = new Directory("jsh");
        Directory hsyDir = new Directory("hsy");
        Directory jjhDir = new Directory("jjh");

        usrDir.add(jshDir);
        usrDir.add(hsyDir);
        usrDir.add(jjhDir);

        jshDir.add(new File("diary.html", 100));
        jshDir.add(new File("Composite.java", 200));
        hsyDir.add(new File("memo.txt", 300));
        hsyDir.add(new File("index.html", 350));
        jjhDir.add(new File("game.doc", 400));
        jjhDir.add(new File("junk.mail", 500));

        rootDir.accept(new ListVisitor());
        System.out.println();

        FileFindVisitor fileFindVisitor = new FileFindVisitor(".html");
        rootDir.accept(fileFindVisitor);

        System.out.println("HTML files are: ");
        for (File file : fileFindVisitor.getFoundFiles()) {
            System.out.println(file);
        }
    }

}
