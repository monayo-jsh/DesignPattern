public interface Mediator {
    void createColleagues();

    //Colleague 상태가 변화했을 때 호출된다.
    void colleagueChanged();
}
