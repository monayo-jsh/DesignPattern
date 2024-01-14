package second;

import second.template.CharDisplay;
import second.template.Display;
import second.template.StringDisplay;

public class Applicaiton {

    public static void main(String[] args) {

        Display charDisplay = new CharDisplay('H');
        charDisplay.display();

        System.out.println();

        Display stringDisplay = new StringDisplay("Hello, world.");
        stringDisplay.display();

    }

}
