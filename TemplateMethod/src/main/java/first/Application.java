package first;

import first.template.abstr.AbstractDisplay;
import first.template.abstr.CharDisplay;
import first.template.abstr.StringDisplay;
import first.template.inter.InterfaceDisplay;
import first.template.inter.StringDisplayImpl;

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
