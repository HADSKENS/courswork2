import java.text.ParseException;
import java.util.Date;

public class MonthlyTask extends Task{
    public MonthlyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(Date date) {
        return getDate().getDate()==date.getDate();
    }
}
