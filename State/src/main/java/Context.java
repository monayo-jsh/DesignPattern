public interface Context {

    //시간 설정
    void setClock(int hour);

    //상태 전환
    void changeState(State state);

    //경비센터 경비원 호출
    void callSecurityCenter(String alarm);

    //경비센터 기록
    void recordLog(String log);

}
