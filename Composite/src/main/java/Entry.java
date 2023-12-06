public abstract class Entry {

    private Entry parent;

    protected void setParent(Entry parent) {
        this.parent = parent;
    }

    public abstract String getName();
    public abstract long getSize();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + this.getSize() + ")";
    }

    public String getFullPath() {
        StringBuilder fullPath = new StringBuilder();
        Entry entry = this;
        do {
            fullPath.insert(0, entry.getName());
            fullPath.insert(0, "/");
            entry = entry.parent;
        } while (entry != null);
        return fullPath.toString();
    }
}
