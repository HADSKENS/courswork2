import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeeklyTask extends Task{
    public WeeklyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(Date date){
        return getDate().getDay()==date.getDay();
    }
}
