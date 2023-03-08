import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask (String header, String description, TypeTask typeTask, Periodicity periodicity) {
        super(header,description,typeTask,periodicity);
    }
    @Override
    public boolean dayTask(LocalDate date){
        return getDate().getDayOfMonth()+1==date.getDayOfMonth() & getDate().getMonth()==date.getMonth() & getDate().getYear()==date.getYear();
    }
}
