import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Diary {
    public Diary() {
    }

    private final Scanner scanner = new Scanner(System.in);
    private final List<Task> diary = new ArrayList<>();
    String a1;
    String b1;
    int count;
    String date;
    String date1;
    int result;
    Date currentDay = new Date();
    Calendar cal = Calendar.getInstance();

    private void printMenu() {
        System.out.println("Выберите частоту повтора задачи");
        System.out.println("1 - Один раз");
        System.out.println("2 - Ежедневно");
        System.out.println("3 - Еженедельно");
        System.out.println("4 - Ежемесячно");
        System.out.println("5 - Ежегодно");
    }

    private void menuChoice(int num) {
        switch (num) {
            case 1:
                Task a = new Task(a1, b1, TypeTask.personal, Periodicity.onlyone);
                diary.add(a);
                break;
            case 2:
                Task b = new Task(a1, b1, TypeTask.personal, Periodicity.oneonday);
                diary.add(b);
                break;
            case 3:
                Task c = new Task(a1, b1, TypeTask.personal, Periodicity.oneonweek);
                diary.add(c);
                break;
            case 4:
                Task d = new Task(a1, b1, TypeTask.personal, Periodicity.oneonmonth);
                diary.add(d);
                break;
            case 5:
                Task e = new Task(a1, b1, TypeTask.personal, Periodicity.oneonyear);
                diary.add(e);
                break;
            default:
                System.out.println("Не понимаю");
        }
    }

    public void deleteTaskIfHaveId() {
        if (diary.size() == 0) {
            System.out.println("Задач не обнаружено");
        }
        else {
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
    public void taskNextDay() throws ParseException {
        for (Task a : diary) {
            date = a.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            result = date1.compareTo(currentDay);
            if (result == 1) {
                System.out.println(a);
            }
        }
    }

    public void addTaskPersonal() {
        System.out.println("Ввдеите заголовок, а потом описание вашей задачи");
        a1 = scanner.next();
        b1 = scanner.next();
        printMenu();
        if (scanner.hasNext()) {
            menuChoice(scanner.nextInt());
        }
    }

    public void addTaskWorking() {
        System.out.println("Ввдеите заголовок, а потом описание вашей задачи");
        a1 = scanner.next();
        b1 = scanner.next();
        printMenu();
        if (scanner.hasNext()) {
            menuChoice(scanner.nextInt());
        }

    }

    public void printAll() {
        if(diary.size()==0){
            System.out.println("Задач не обнаружено");
        }
        else {
            for (Task task : diary) {
                System.out.println(task);
            }
        }
    }
}
