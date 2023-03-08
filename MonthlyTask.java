import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String header, String description, TypeTask typeTask, Periodicity periodicity){
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(LocalDate date) {
        return getDate().getDayOfMonth()==date.getDayOfMonth();
    }
}
