import language.Context;
import language.InterpreterFacade;
import language.Node;
import language.ProgramNode;
import language.exception.ParseException;
import turtle.TurtleCnavas;
import turtle.TurtleExecutorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Files;
import java.nio.file.Path;

public class Application extends JFrame {

    private TurtleCnavas canvas = new TurtleCnavas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(new TurtleExecutorFactory(canvas));
    private TextField programTextField = new TextField("program repeat 4 repeat 3 go right go left end right end end");

    public static void main(String[] args) {
        //console();
        gui();
    }


    private static void console() {
        try {

            for (String text: Files.readAllLines(Path.of("program.txt"))) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Application(String title) {
        super(title);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout());

        programTextField.addActionListener(e -> parseAndExecute());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        pack();
        setVisible(true);

        parseAndExecute();
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        try {
            facade.parse(programText);
            canvas.repaint();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void gui() {
        new Application("Interpreter Pattern Sample");
    }
}
