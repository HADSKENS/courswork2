import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OneTimeTask extends Task{
    public OneTimeTask (String header, String description, TypeTask typeTask, Periodicity periodicity) {
        super(header,description,typeTask,periodicity);
    }
    @Override
    public boolean dayTask(Date date){
        return getDate().getDate()+1==date.getDate() & getDate().getMonth()==date.getMonth() & getDate().getYear()==date.getYear();
    }
}
