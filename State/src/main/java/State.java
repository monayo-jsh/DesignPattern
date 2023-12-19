public interface State {
    //기능 인터페이스로 기능 구현은 구현체에서 담당

    //시간 설정
    void doClock(Context context, int hour);

    //금고 사용
    void doUse(Context context);

    //비상벨
    void doAlarm(Context context);

    //일반 통화
    void doPhone(Context context);

}
