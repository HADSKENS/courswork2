import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OneTimeTask extends Task{
    public OneTimeTask (String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        super(header,description,typeTask,periodicity);
    }
    @Override
    public void dayTask(Task task, Date date) throws ParseException{
        SimpleDateFormat date1 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
        Date dateTask = date1.parse(task.getDate());
        if (dateTask.getDate()+1==date.getDate() & dateTask.getMonth()==date.getMonth() & dateTask.getYear()==date.getYear()){
            System.out.println(task);
        }
    }
}
