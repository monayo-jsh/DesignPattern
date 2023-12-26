package turtle;

import language.Executor;

import java.awt.*;

public class TurtleCnavas extends Canvas {
    final static int UNIT_LENGTH = 30; //움직일 때 단위 길이
    final static int DIRECTION_UP = 0; //위쪽
    final static int DIRECTION_RIGHT = 3; //오른쪽
    final static int DIRECTION_DOWN = 6; //아래쪽
    final static int DIRECTION_LEFT = 9; //왼쪽
    final static int RELATIVE_DIRECTION_RIGHT = 3; //오른쪽으로 향함
    final static int RELATIVE_DIRECTION_LEFT = -3; //왼쪽으로 향함
    final static int RADIUS = 3; //반지름

    private int direction = 0;
    private Point position;
    private Executor executor;

    public TurtleCnavas(int width, int height) {
        setSize(width, height);
        initialize();
    }

    private void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;

        setForeground(Color.RED);
        setBackground(Color.WHITE);
        Graphics graphics = getGraphics();
        if (graphics != null) {
            graphics.clearRect(0, 0, size.width, size.height);
        }
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    void setRelativeDrection(int relativeDrection) {
        setDirection(direction + relativeDrection);
    }

    void setDirection(int direction) {
        int dir = direction % 12;

        if (direction < 0) {
            dir = 12 - (-direction) % 12;
        }

        this.direction = dir % 12;
    }

    void go(int length) {
        int newX = position.x;
        int newY = position.y;

        switch (direction) {
            case DIRECTION_UP:
                newY -= length;
                break;
            case DIRECTION_RIGHT:
                newX += length;
                break;
            case DIRECTION_DOWN:
                newY += length;
                break;
            case DIRECTION_LEFT:
                newX -= length;
                break;
            default:
                break;
        }

        Graphics graphics = getGraphics();
        if (graphics != null) {
            graphics.drawLine(position.x, position.y, newX, newY);
            graphics.fillOval(newX - RADIUS, newY - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1);
        }

        position.x = newX;
        position.y = newY;
    }

    @Override
    public void paint(Graphics g) {
        initialize();
        if (executor != null) {
            executor.execute();
        }
    }
}
