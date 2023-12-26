package turtle;

import language.Executor;
import language.ExecutorFactory;

public class TurtleExecutorFactory implements ExecutorFactory {

    private final TurtleCnavas canvas;

    private class GoExecutor implements Executor {
        @Override
        public void execute() {
            canvas.go(TurtleCnavas.UNIT_LENGTH);
        }
    }

    private class LeftExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDrection(TurtleCnavas.RELATIVE_DIRECTION_LEFT);
        }
    }

    private class RightExecutor implements Executor {
        @Override
        public void execute() {
            canvas.setRelativeDrection(TurtleCnavas.RELATIVE_DIRECTION_RIGHT);
        }
    }

    public TurtleExecutorFactory(TurtleCnavas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Executor createExecutor(String name) {
        if ("go".equals(name)) {
            return new GoExecutor();
        }

        if ("right".equals(name)) {
            return new RightExecutor();
        }

        if ("left".equals(name)) {
            return new LeftExecutor();
        }

        throw new IllegalArgumentException("Error: Unknown <primitive command>: '" + name + "'");
    }
}
