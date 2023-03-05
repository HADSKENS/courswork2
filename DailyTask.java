import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DailyTask extends Task {
    String date2;
    Date datePreservation = new Date();
    SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);

    public DailyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        super(header, description, typeTask, periodicity);
        date2 = getDate();
        this.datePreservation = d2.parse(date);
    }

    public Date getDatePreservation() {
        return datePreservation;
    }

    public void setDatePreservation(Date datePreservation) {
        this.datePreservation = datePreservation;
    }
}
