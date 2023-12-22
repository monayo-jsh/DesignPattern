package command;

import java.util.ArrayDeque;
import java.util.Deque;

public class MacroCommand implements Command {

    private final Deque<Command> commands;

    public MacroCommand() {
        this.commands = new ArrayDeque<>();
    }

    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }

    //명령 추가
    public void append(Command command) {
        if (command == this) {
            throw new IllegalArgumentException("infinite loop caused by append.");
        }

        commands.push(command);
    }

    //마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    //전부 삭제
    public void clear() {
        commands.clear();
    }
}
