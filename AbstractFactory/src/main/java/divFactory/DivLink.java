package divFactory;

import factory.Link;

public class DivLink extends Link {

    public DivLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return String.format("<div class=\"LINK\"><a href=\"%s\">%s</a></div>\n", url, caption);
    }

}
