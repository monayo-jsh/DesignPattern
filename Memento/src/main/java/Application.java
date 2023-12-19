import game.Gamer;
import game.Memento;

public class Application {

    public static final String SAVE_FILE_NAME = "game.dat";

    public static void main(String[] args) {

        Gamer gamer = new Gamer(100); // 최초 소지금 100 시작
        Memento memento = gamer.createMemento(); // 최초 상태 저장

        Memento loadSaveFile = Memento.loadFromFile(SAVE_FILE_NAME);
        if (loadSaveFile != null) {
            memento = loadSaveFile;
            gamer.restoreMememto(loadSaveFile);
        }

        for (int i=0; i<100; i++) {
            System.out.println("==== " + i); //횟수 표시
            System.out.println("상태: " + gamer); //현재 게이머 상태

            //내기 게임 진행
            gamer.bet();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            //Mememto 취급 방법 결정
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("* 많이 늘었으니 현재 상태를 저장");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("* 많이 줄었으니 이전 상태를 복원");
                gamer.restoreMememto(memento);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {}

            System.out.println();
        }

        //게임 결과 저장
        boolean saved = Memento.saveToFile(SAVE_FILE_NAME, memento);
        System.out.println("결과 저장 : " + saved);
    }

}
