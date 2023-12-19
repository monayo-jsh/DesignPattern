public class NightState implements State {

    private final static NightState sigletone = new NightState();

    //생성자 막음
    private NightState() {}

    public static State getInstance() {
        return sigletone;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("비상:야간 금고 사용 !");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야간)");

        //비상벨 호출 시 비상 상태 전환
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야간]";
    }
}
