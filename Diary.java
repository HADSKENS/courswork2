import java.security.spec.RSAOtherPrimeInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Diary{

    public Diary() {
    }

    private final Scanner scanner = new Scanner(System.in);
    public final List<Task> diary = new ArrayList<>();
    String a1;
    String b1;
    int count;

    private void printMenu() {
        System.out.println("Выберите частоту повтора задачи");
        System.out.println("1 - Один раз");
        System.out.println("2 - Ежедневно");
        System.out.println("3 - Еженедельно");
        System.out.println("4 - Ежемесячно");
        System.out.println("5 - Ежегодно");
    }

    private void menuChoice(int num) throws ParseException {
        switch (num) {
            case 1:
                OneTimeTask a = new OneTimeTask(a1, b1, TypeTask.personal, Periodicity.OnlyOne);
                diary.add(a);
                break;
            case 2:
                DailyTask b = new DailyTask(a1, b1, TypeTask.personal, Periodicity.OneOnDay);
                diary.add(b);
                break;
            case 3:
                WeeklyTask c = new WeeklyTask(a1, b1, TypeTask.personal, Periodicity.OneOnWeek);
                diary.add(c);
                break;
            case 4:
                MonthlyTask d = new MonthlyTask(a1, b1, TypeTask.personal, Periodicity.OneOnMonth);
                diary.add(d);
                break;
            case 5:
                YearlyTask e = new YearlyTask(a1, b1, TypeTask.personal, Periodicity.OneOnYear);
                diary.add(e);
                break;
            default:
                System.out.println("Не понимаю");
        }
    }

    private void menuChoice1(int num) throws ParseException {
        switch (num) {
            case 1:
                OneTimeTask a = new OneTimeTask(a1, b1, TypeTask.working, Periodicity.OnlyOne);
                diary.add(a);
                break;
            case 2:
                DailyTask b = new DailyTask(a1, b1, TypeTask.working, Periodicity.OneOnDay);
                diary.add(b);
                break;
            case 3:
                WeeklyTask c = new WeeklyTask(a1, b1, TypeTask.working, Periodicity.OneOnWeek);
                diary.add(c);
                break;
            case 4:
                MonthlyTask d = new MonthlyTask(a1, b1, TypeTask.working, Periodicity.OneOnMonth);
                diary.add(d);
                break;
            case 5:
                YearlyTask e = new YearlyTask(a1, b1, TypeTask.working, Periodicity.OneOnYear);
                diary.add(e);
                break;
            default:
                System.out.println("Не понимаю");
        }
    }

    public void deleteTaskIfHaveId() {
        if (diary.size() == 0) {
            System.out.println("Задач не обнаружено");
        } else {
            System.out.println("Введите ID");
            count = scanner.nextInt();
            for (int i = 0; i < diary.size(); i++) {
                Task a = diary.get(i);
                if (count == a.getId()) {
                    diary.remove(i);
                }
            }
        }
    }

    public void taskNextDay() throws ParseException{
        for (Task task : diary) {
            if (task.getPeriodicity().compareTo(Periodicity.OnlyOne.name()) == 0) {
                    Periodicity.OnlyOne.nextTimeActuation(task);
            }
            if (task.getPeriodicity().compareTo(Periodicity.OneOnDay.name())==0){
                Periodicity.OneOnDay.nextTimeActuation(task);
            }
            if (task.getPeriodicity().compareTo(Periodicity.OneOnWeek.name())==0) {
                Periodicity.OneOnWeek.nextTimeActuation(task);
            }
            if (task.getPeriodicity().compareTo(Periodicity.OneOnMonth.name())==0){
                Periodicity.OneOnMonth.nextTimeActuation(task);
            }
            if (task.getPeriodicity().compareTo(Periodicity.OneOnYear.name())==0){
                Periodicity.OneOnYear.nextTimeActuation(task);
            }
        }
    }

    public void addTaskPersonal() throws ParseException {
        System.out.println("Ввдеите заголовок, а потом описание вашей задачи");
        a1 = scanner.next();
        b1 = scanner.next();
        printMenu();
        if (scanner.hasNext()) {
            menuChoice(scanner.nextInt());
        }
    }

    public void addTaskWorking() throws ParseException {
        System.out.println("Ввдеите заголовок, а потом описание вашей задачи");
        a1 = scanner.next();
        b1 = scanner.next();
        printMenu();
        if (scanner.hasNext()) {
            menuChoice1(scanner.nextInt());
        }

    }

    public void printAll() {
        if (diary.size() == 0) {
            System.out.println("Задач не обнаружено");
        } else {
            for (Task task : diary) {
                System.out.println(task);
            }
        }
    }
}
