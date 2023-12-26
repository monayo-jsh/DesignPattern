package language;

import language.exception.ParseException;

import java.util.ArrayList;
import java.util.List;

// <command list> ::= <command>* end
public class CommandListNode extends Node {

    private final List<Node> list = new ArrayList<>();

    @Override
    public void execute() {
        for (Node node : list) {
            node.execute();
        }
    }

    @Override
    public void parse(Context context) throws ParseException {

        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Error: Mission 'end'");
            }

            if ("end".equals(context.currentToken())) {
                context.skipToken("end");
                break;
            }

            Node commandNode = new CommandNode();
            commandNode.parse(context);
            list.add(commandNode);
        }

    }

    @Override
    public String toString() {
        return list.toString();
    }
}
