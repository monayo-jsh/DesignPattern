package listFactory;

import factory.Item;
import factory.Tray;

import java.util.stream.Collectors;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        return new StringBuilder()
                .append("<li>\n")
                .append(caption)
                .append("\n<ul>\n")
                .append(tray.stream()
                            .map(Item::makeHTML)
                            .collect(Collectors.joining("\n")))
                .append("</ul>\n")
                .append("</li>\n")
                .toString();
    }

}
