import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    String header;
    String description;
    String type;
    String periodicity;
    int id;
    static int numberCreation;
    LocalDate dateCreate1 = LocalDate.now();
    LocalDate dateCreate;

    public Task(String header, String description, TypeTask typeTask, Periodicity periodicity) {
        dateCreate = dateCreate1;
        id = getNumberCreation();
        this.header = header;
        this.description = description;
        this.type = typeTask.name();
        this.periodicity = periodicity.name();
        numberCreation++;
    }

    public static int getNumberCreation() {
        return numberCreation;
    }

    public LocalDate getDate() {
        return dateCreate;
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

    abstract boolean dayTask(LocalDate date);

    @Override
    public String toString() {
        return
                "Id=" + id + ", task{" + '\'' +
                        "header='" + header + '\'' +
                        ", description='" + description + '\'' +
                        ", type='" + type + '\'' +
                        ", periodicity='" + periodicity + '\'' +
                        ", dateCreate='" + dateCreate + '}';

    }
}
