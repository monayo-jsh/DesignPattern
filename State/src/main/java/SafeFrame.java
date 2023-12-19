import java.awt.*;

public class SafeFrame extends Frame implements Context {

    private final TextField textClock = new TextField(50); //현재 시간 표시용
    private final TextArea textScreen = new TextArea(10, 60); //경비 센터 출력용
    private final Button buttonUse = new Button("금고 사용"); //금고 사용 버튼
    private final Button buttonAlarm = new Button("비상벨"); //비상벨 버튼
    private final Button buttonPhone = new Button("일반 통화"); //일반 통화 버튼
    private final Button buttonExit = new Button("종료"); //종료 버튼

    private State state = DayState.getInstance(); //현재 상태

    public SafeFrame(String title) {
        super(title);

        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        //현재 시간 표시 배치
        textClock.setEditable(false);
        add(textClock, BorderLayout.NORTH);

        //경비 센터 출력 배치
        textScreen.setEditable(false);
        add(textScreen, BorderLayout.CENTER);

        //버튼 배치
        Panel buttonPanel = new Panel();
        buttonPanel.add(buttonUse);
        buttonPanel.add(buttonAlarm);
        buttonPanel.add(buttonPhone);
        buttonPanel.add(buttonExit);
        add(buttonPanel, BorderLayout.SOUTH);

        //리스너 설정
        buttonUse.addActionListener(e -> state.doUse(this));
        buttonAlarm.addActionListener(e -> state.doAlarm(this));
        buttonPhone.addActionListener(e -> state.doPhone(this));
        buttonExit.addActionListener(e -> System.exit(0));

        //GUI 표시
        pack();
        setVisible(true);

    }

    @Override
    public void setClock(int hour) {
        //시간 설정
        String clockString = String.format("현재 시간은 %02d:00", hour);
        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        //상태 전환
        System.out.println(this.state + "에서" + state + "으로 상태가 변화했습니다.");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        //경비 센터 경비원 호출
        textScreen.append("call! " + msg + "\n");
    }

    @Override
    public void recordLog(String log) {
        //경비 센터 기록
        textScreen.append("record ... " + log + "\n");
    }

}
