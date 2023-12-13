import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);

        setBackground(Color.lightGray);

        setLayout(new GridLayout(4, 2));

        //Colleague 생성
        createColleagues();

        //컴포넌트 배치
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);

        //활성화 여부 초기 설정
        colleagueChanged();

        // 표시
        pack();
        setVisible(true);
    }

    @Override
    public void createColleagues() {
        //Colleague 초기화
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", checkboxGroup, true);
        checkLogin = new ColleagueCheckbox("Login", checkboxGroup, false);

        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');

        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        //Mediator 설정
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {
            //게스트 체크
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
            return;
        }

        //사용자 체크
        textUser.setColleagueEnabled(true);
        userpassChanged();
    }

    public void userpassChanged() {
        if (textUser.getText().length() > 0) {
            //username 입력된 경우
            textPass.setColleagueEnabled(true);
            buttonOk.setColleagueEnabled(textPass.getText().length() > 0);
            return;
        }

        //입력되지 않은 경우
        textPass.setColleagueEnabled(false);
        buttonOk.setColleagueEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
