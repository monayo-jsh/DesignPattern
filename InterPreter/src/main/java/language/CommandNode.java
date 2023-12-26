package language;


import language.exception.ParseException;

// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends Node {

    private Node node;

    @Override
    public void execute() {
        node.execute();
    }

    @Override
    public void parse(Context context) throws ParseException {

        if ("repeat".equals(context.currentToken())) {
            node = new RepeatCommandNode();
            node.parse(context);
            return;
        }

        node = new PrimitiveCommandNode();
        node.parse(context);

    }

    @Override
    public String toString() {
        return node.toString();
    }
}
