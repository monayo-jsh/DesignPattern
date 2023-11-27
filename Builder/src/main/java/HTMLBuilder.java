import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HTMLBuilder implements Builder {

    private String filename;
    private final StringBuilder sb;

    public HTMLBuilder() {
        this.filename = "untitled.html";
        this.sb = new StringBuilder();
    }

    public String getHTMLResult() {
        return this.filename;
    }

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        sb.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head><title>")
                .append(title)
                .append("</title></head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(title)
                .append("</h1>\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>")
          .append(str)
          .append("</p>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for(String s: items) {
            sb.append("<li>")
              .append(s)
              .append("</li>\n");
        }
        sb.append("</ul>\n\n");
    }

    @Override
    public void close() {
        sb.append("</body>\n")
          .append("</html>\n");

        try {
            Writer writer = new FileWriter(filename);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
