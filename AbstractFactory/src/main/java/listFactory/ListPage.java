package listFactory;

import factory.Item;
import factory.Page;

import java.util.stream.Collectors;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        return new StringBuilder()
                .append("<!DOCTYPE html>\n")
                .append("<html><head><title>")
                .append(title)
                .append("</title></head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(title)
                .append("</h1>\n")
                .append("<ul>\n")
                .append(contents.stream()
                                .map(Item::makeHTML)
                                .collect(Collectors.joining()))
                .append("</ul\n")
                .append("<hr><address>")
                .append(author)
                .append("</address>\n")
                .append("</body></html>\n")
                .toString();
    }

}
