import java.util.Date;

public class YearlyTask extends Task{
    public YearlyTask(String header, String description, TypeTask typeTask, Periodicity periodicity){
        super(header, description, typeTask, periodicity);
    }
    @Override
    public boolean dayTask(Date date){
        return getDate().getMonth()==date.getMonth() & getDate().getDate()==date.getDate() & getDate().getYear()<=date.getYear();
    }
}
