import java.time.LocalDate;

public class WeeklyTask extends Task{
    public WeeklyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) {
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(LocalDate date){
        return getDate().getDayOfWeek()==date.getDayOfWeek();
    }
}
