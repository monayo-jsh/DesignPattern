package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Memento {

    private final int money;
    private int number;
    private final List<String> fruits;

    //same package
    //wide interface
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    //same package
    //wide interface
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    //wide interface
    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    //narrow interface
    public int getMoney() {
        return money;
    }

    public static boolean saveToFile(String filename, Memento memento) {
        //Momento 인스턴스가 가진 정보를 파일에 저장한다.
        //파일명은 filename 으로 지정한다.
        //저장에 성공하면 True, 실패하면 False

        try {
            StringBuilder data = new StringBuilder()
                    .append(String.format("%d", memento.getMoney()))
                    .append("\n");

            for(String fruit : memento.getFruits()) {
                data.append(fruit);
                data.append("\n");
            }

            Files.writeString(Path.of(filename),
                              data,
                              StandardOpenOption.CREATE,
                              StandardOpenOption.TRUNCATE_EXISTING,
                              StandardOpenOption.WRITE);

        }  catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Memento loadFromFile(String filename) {
        //saveToFile 로 저장한 파일의 정보를 바탕으로 Memento의 인스턴스를 생성
        //파일명은 filename 으로 지정한다.
        //파일 읽기에 실패했을 경우에는 null을 반환한다.

        try {
            List<String> lines = Files.readAllLines(Path.of(filename));

            if (lines.size() == 0) {
                System.out.println("Empty file");
                return null;
            }

            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0));
            } catch (NumberFormatException e) {
                System.out.println("Format error: " + e);
                return null;
            }

            Memento memento = new Memento(money);
            for(int i=1; i<lines.size(); i++) {
                memento.addFruit(lines.get(i));
            }

            return memento;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
