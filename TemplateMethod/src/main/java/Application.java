import template.abstr.AbstractDisplay;
import template.abstr.CharDisplay;
import template.abstr.StringDisplay;
import template.inter.InterfaceDisplay;
import template.inter.StringDisplayImpl;

public class Application {

    public static void main(String[] args) {

        AbstractDisplay charDisplay = new CharDisplay('H');
        charDisplay.display();

        AbstractDisplay stringDisplay = new StringDisplay("Hello, World.");
        stringDisplay.display();

        InterfaceDisplay interfaceDisplay = new StringDisplayImpl("Hi, JSH");
        interfaceDisplay.display();
    }

}
