import command.ColorCommand;
import command.Command;
import command.MacroCommand;
import drawer.DrawCanvas;
import drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Applicaiton extends JFrame {

    //그리기 이력
    private final MacroCommand history = new MacroCommand();

    //그리는 영역
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);

    private final JButton redButton = new JButton("red");
    private final JButton greenButton = new JButton("green");
    private final JButton blueButton = new JButton("blue");
    private final JButton clearButton = new JButton("clear");
    private final JButton undoButton = new JButton("undo");

    public Applicaiton(String title) {
        super(title);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });

        redButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.RED);
            history.append(command);
            command.execute();
        });

        greenButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.GREEN);
            history.append(command);
            command.execute();
        });

        blueButton.addActionListener(e -> {
            Command command = new ColorCommand(canvas, Color.BLUE);
            history.append(command);
            command.execute();
        });

        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Applicaiton("Command Pattern Sample");
    }
}
