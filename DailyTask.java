import java.text.ParseException;
import java.util.Date;

public class DailyTask extends Task {

    public DailyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        super(header, description, typeTask, periodicity);
    }

    @Override
    public boolean dayTask(Date date){
        return true;
    }
}
