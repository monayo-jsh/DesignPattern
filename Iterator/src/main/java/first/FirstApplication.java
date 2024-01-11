package first;

import java.util.Iterator;

public class FirstApplication {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        //명시적으로 Iterator 사용
        Iterator<Book> iter = bookShelf.iterator();
        while (iter.hasNext()) {
            Book book = iter.next();
            System.out.println("book.getName() = " + book.getName());
        }
        System.out.println();

        //확장 for 사용
        for (Book book : bookShelf) {
            System.out.println("book.getName() = " + book.getName());
        }
        System.out.println();
    }
}
