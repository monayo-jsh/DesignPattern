package pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {

    public static void makeWelcomePage(String mailaddr, String filename) {

        try {
            Properties mailProp = Database.getProperties("maildata");
            String username = mailProp.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();

            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void makeLinkPage(String filename) {

        try {
            Properties mailProp = Database.getProperties("maildata");
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");
            for (String mailaddr : mailProp.stringPropertyNames()) {
                String username = mailProp.getProperty(mailaddr);
                writer.mailto(mailaddr, username);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
