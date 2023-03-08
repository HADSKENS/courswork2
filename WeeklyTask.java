import java.util.Date;

public class WeeklyTask extends Task{
    public WeeklyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) {
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(Date date){
        return getDate().getDay()==date.getDay();
    }
}
