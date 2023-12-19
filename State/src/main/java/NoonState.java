public class NoonState implements State {
    private final static State sigletone = new NoonState();

    private NoonState() {}

    public static State getInstance() {
        return sigletone;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
            return;
        }

        context.changeState(DayState.getInstance());
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("비상: 점심 시간에 금고 사용!");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(점심 시간)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("점심 시간 통화 녹음");
    }

    @Override
    public String toString() {
        return "[점심 시간]";
    }
}
