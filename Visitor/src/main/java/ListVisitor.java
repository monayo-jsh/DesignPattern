public class ListVisitor extends Visitor {

    private String currentDir = "";


    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String origDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        for (Entry entry : directory) {
            entry.accept(this);
        }
        currentDir = origDir;
    }
}
