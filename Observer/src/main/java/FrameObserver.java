import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {

    static class GraphText extends TextField implements Observer {

        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i=0; i<number; i++) {
                text += "*";
            }
            setText(text);
        }
    }

    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint();
        }

        public void paint(Graphics graphics) {
            int width = getWidth();
            int height = getHeight();
            graphics.setColor(Color.WHITE);
            graphics.fillArc(0, 0, width, height, 0, 360);
            graphics.setColor(Color.RED);
            graphics.fillArc(0, 0, width, height, 90, - number * 360 / 50);
        }
    }

    private final GraphText graphText = new GraphText(60);
    private final GraphCanvas graphCanvas = new GraphCanvas();
    private final Button buttonClose = new Button("Close");

    public FrameObserver() {
        super("FrameObserver");

        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        graphText.setEditable(false);
        graphCanvas.setSize(500, 500);

        add(graphText, BorderLayout.NORTH);
        add(graphCanvas, BorderLayout.CENTER);
        add(buttonClose, BorderLayout.SOUTH);

        buttonClose.addActionListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void update(NumberGenerator generator) {
        graphText.update(generator);
        graphCanvas.update(generator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
