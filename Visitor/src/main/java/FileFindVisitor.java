import java.util.ArrayList;
import java.util.List;

public class FileFindVisitor extends Visitor {

    private final String extension;
    private final List<File> files = new ArrayList<>();

    public FileFindVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(extension)) {
            files.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for(Entry entry : directory) {
            entry.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return files;
    }
}
