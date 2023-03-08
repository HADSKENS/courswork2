import java.time.LocalDate;

public class DailyTask extends Task {

    public DailyTask(String header, String description, TypeTask typeTask, Periodicity periodicity) {
        super(header, description, typeTask, periodicity);
    }

    @Override
    public boolean dayTask(LocalDate date) {
        return true;
    }
}
