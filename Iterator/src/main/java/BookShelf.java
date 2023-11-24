import java.util.Iterator;

public class BookShelf implements Iterable<Book>{

    private final Book[] books;
    private int last;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
        this.last = 0;
    }

    public Book getBookAt(int index) {
        return this.books[index];
    }

    public void appendBook(Book book) {
        this.books[this.last] = book;
        this.last++;
    }

    public int getLength() {
        return this.last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
