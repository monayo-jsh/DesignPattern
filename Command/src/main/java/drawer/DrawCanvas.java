package drawer;

import command.ColorCommand;
import command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    private final MacroCommand history;
    private Color color;
    private int radius;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);

        this.history = history;

        init();
    }

    @Override
    public void init() {
        color = Color.RED;
        radius = 6;

        history.append(new ColorCommand(this, color));
    }

    //그리기
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    //이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        history.execute();
    }
}
