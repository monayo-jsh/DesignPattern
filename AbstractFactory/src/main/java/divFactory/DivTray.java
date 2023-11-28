package divFactory;

import factory.Item;
import factory.Tray;

import java.util.stream.Collectors;

public class DivTray extends Tray {

    public DivTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        return new StringBuilder()
                .append("<p><b>")
                .append(caption)
                .append("</b></p>\n")
                .append("<div class=\"TRAY\">")
                .append(tray.stream()
                            .map(Item::makeHTML)
                            .collect(Collectors.joining()))
                .append("</div>\n")
                .toString();
    }
}
