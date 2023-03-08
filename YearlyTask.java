import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String header, String description, TypeTask typeTask, Periodicity periodicity){
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(LocalDate date){
        return getDate().getMonth()==date.getMonth() & getDate().getDayOfMonth()==date.getDayOfMonth() & getDate().getYear()<=date.getYear();
    }
}
