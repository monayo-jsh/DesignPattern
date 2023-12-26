package language;

import language.exception.ParseException;

// <primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {

    private String name;
    private Executor executor;

    @Override
    public void execute() {
        executor.execute();
    }

    @Override
    public void parse(Context context) throws ParseException {

        name = context.currentToken();

        if (name == null) {
            throw new ParseException("Error: Mission <primitive command>");
        }

        if (!"go".equals(name) && !"right".equals(name) && !"left".equals(name)) {
            throw new ParseException("Error: Unknown <primitive command>: '" + name + "'");
        }

        context.skipToken(name);
        executor = context.createExecutor(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
