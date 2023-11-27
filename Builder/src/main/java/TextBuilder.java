public class TextBuilder implements Builder {

    private final StringBuilder sb;

    public TextBuilder() {
        this.sb = new StringBuilder();
    }

    public String getTextResult() {
        return sb.toString();
    }

    @Override
    public void makeTitle(String title) {
        sb.append("======================================\n")
          .append("[")
          .append(title)
          .append("]")
          .append("\n\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("ㅁ")
          .append(str)
          .append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for(String s: items) {
            sb.append(" .")
              .append(s)
              .append("\n");
        }

        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("======================================\n");
    }
}
