package language;

import language.exception.ParseException;

import java.util.Objects;

public class Context implements ExecutorFactory {

    private ExecutorFactory factory;
    private final String[] tokens;
    private String lastToken;
    private int index;

    public Context(String command) {
        this.tokens = command.split("\\s+");
        this.index = 0;
        nextToken();
    }

    public String nextToken() {
        if (index < tokens.length) {
            lastToken = tokens[index++];
        } else {
            lastToken = null;
        }

        return lastToken;
    }

    public void skipToken(String token) throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: '" + token + "' is expected, but no more token is found.");
        }

        if (!Objects.equals(token, currentToken())) {
            throw new ParseException("Error: '" + token + "' is expected, but '" + currentToken() + "' is found.");
        }

        nextToken();
    }

    public String currentToken() {
        return lastToken;
    }

    public int currentNumber() throws ParseException {
        if (currentToken() == null) {
            throw new ParseException("Error: No more token.");
        }

        try {
            return Integer.parseInt(currentToken());
        } catch (NumberFormatException e) {
            throw new ParseException("Error: " + e);
        }
    }

    public void setExecutorFactory(ExecutorFactory factory) {
        this.factory = factory;
    }

    @Override
    public Executor createExecutor(String name) {
        return factory.createExecutor(name);
    }
}
