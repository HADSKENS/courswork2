import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class Task{
    String header;
    String description;
    String type;
    String periodicity;
    int id;
    static int numberCreation;
    Calendar cal = Calendar.getInstance();
    String date;
    Date dateCreate = new Date();

    public Task(String header, String description, TypeTask typeTask, Periodicity periodicity) throws ParseException {
        this.date = String.valueOf(dateCreate);
        id = getNumberCreation();
        this.header = header;
        this.description = description;
        this.type = typeTask.stringTask;
        this.periodicity = periodicity.name();
        numberCreation++;
    }

    public static int getNumberCreation() {
        return numberCreation;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getPeriodicity() {
        return periodicity;
    }
    public void dayTask(Task task,Date date) throws ParseException {}

    @Override
    public String toString() {
        return
                "Id=" + id + ", task{" + '\'' +
                        "header='" + header + '\'' +
                        ", description='" + description + '\'' +
                        ", type='" + type + '\'' +
                        ", periodicity='" + periodicity + '\'' +
                        ", dateCreate='" + date + '}';

    }
}
