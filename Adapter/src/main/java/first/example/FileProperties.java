package first.example;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {
    Properties properties = new Properties();

    @Override
    public void readFromFile(String filename) throws IOException {
        properties.load(new FileReader(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        String comments = "written by FileProperties";
        properties.store(new FileWriter(filename), comments);
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key, "");
    }

}
