package divFactory;

import factory.Item;
import factory.Page;

import java.util.stream.Collectors;

public class DivPage extends Page {

    public DivPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        return new StringBuilder()
                .append("<!DOCTYPE html>\n")
                .append("<html><head><title>")
                .append(title)
                .append("</title><style>\n")
                .append("div.TRAY { padding:0.5em; margin-left:5em; border:1px solid black; }\n")
                .append("div.LINK { padding:0.5em; background-color: lightgray; }\n")
                .append("</style></head><body>\n")
                .append("<h1>")
                .append(title)
                .append("</h1>\n")
                .append(contents.stream()
                                .map(Item::makeHTML)
                                .collect(Collectors.joining()))
                .append("<hr><address>")
                .append(author)
                .append("</address>\n")
                .append("</body></html>\n")
                .toString();
    }
}
