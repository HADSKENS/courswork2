public enum Periodicity {
    onlyone("Один раз"),oneonday("Ежедневно"),oneonweek("Еженедельно"),oneonmonth("Ежемесячно"),oneonyear("Ежегодно");
    String stringPeriodicity;

    Periodicity(String stringPeriodicity) {
        this.stringPeriodicity=stringPeriodicity;
    }
    public void getNext(){

    }
}
