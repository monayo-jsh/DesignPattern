public class TicketMaker {

    private final static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {}

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    private int ticket = 1000;

    //멀티쓰레드 환경에서 중복되지 않는 유일 값 보장
    public synchronized int getNextTicketNumber() {
        return this.ticket++;
    }
}
