import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameBuilder implements Builder {

    private final JFrame frame = new JFrame();
    private final Box box = new Box(BoxLayout.Y_AXIS);

    @Override
    public void makeTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void makeString(String str) {
        JLabel label = new JLabel(str);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box.add(label);
    }

    @Override
    public void makeItems(String[] items) {
        Box innerBox = new Box(BoxLayout.Y_AXIS);
        for (String caption: items) {
            JButton button = new JButton(caption);
            button.addActionListener(e -> {
                System.out.println(e.getActionCommand());
            });
            innerBox.add(button);
        }

        innerBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        box.add(innerBox);
    }

    @Override
    public void close() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public JFrame getFrameResult() {
        return this.frame;
    }
}
