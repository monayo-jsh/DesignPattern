public class File extends Entry {

    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        // 위와 동일한 코드
        // System.out.println(prefix + "/" + this.toString());
        // System.out.println(prefix + "/" + toString());
    }
}
