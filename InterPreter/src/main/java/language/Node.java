package language;

import language.exception.ParseException;

public abstract class Node implements Executor {
    public abstract void parse(Context context) throws ParseException;
}
