import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Diary {

    public Diary() {
    }

    private final Scanner scanner = new Scanner(System.in);
    public final List<Task> diary = new ArrayList<>();
    public final List<Task> archive = new ArrayList<>();
    String a1;
    String b1;
    int edit;
    String read;

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

    private void menuChoice1(int num) {
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
            edit = scanner.nextInt();
            for (int i = 0; i < diary.size(); i++) {
                Task a = diary.get(i);
                if (edit == a.getId()) {
                    archive.add(diary.get(i));
                    diary.remove(i);
                }
            }
        }
    }

    public void printArchive() {
        if (archive.size() != 0) {
            for (int i = 0; i < archive.size(); i++) {
                System.out.println(archive.get(i));
            }
        } else {
            System.out.println("Архив пуст");
        }
    }

    public void editTask() {
        if (diary.size() == 0) {
            System.out.println("Редактировать нечего");
        } else {
            System.out.println("Введите Id задачи которую вы хотите отредактировать");
            edit = scanner.nextInt();
            for (int i = 0; i < diary.size(); i++) {
                Task a = diary.get(i);
                if (edit == a.getId()) {
                    System.out.println("0 - Отредактировать заголовок");
                    System.out.println("1 - Отредактировать описание");
                    int numpad = scanner.nextInt();
                    switch (numpad) {
                        case 0:
                            System.out.println("Введите новый Заголовок");
                            a.setHeader(scanner.next());
                            System.out.println("Ваш новый заголовок для задачи ");
                            System.out.println(a.getHeader());
                            System.out.println("Хотите отредактировать описание");
                            System.out.println("0 - Да");
                            System.out.println("1 - Нет");
                            numpad=scanner.nextInt();
                            switch (numpad){
                                case 0:
                                    System.out.println("Введите новое описание");
                                    a.setDescription(scanner.next());
                                    break;
                                case 1:
                                    break;
                                default:
                                    System.out.println("Описание осталось без изменений");
                                    break;
                            }
                            break;
                        case 1:
                            System.out.println("Введите Описание");
                            a.setDescription(scanner.next());
                            System.out.println("Ваше новое описание для задачи");
                            System.out.println(a.getDescription());
                            System.out.println("Хотите отредактировать Заголовок");
                            System.out.println("0 - Да");
                            System.out.println("1 - Нет");
                            numpad=scanner.nextInt();
                            switch (numpad){
                                case 0:
                                    System.out.println("Введите новый заголовок");
                                    a.setHeader(scanner.next());
                                    break;
                                case 1:
                                    break;
                                default:
                                    System.out.println("Заголовок остался без изменений");
                            }
                            break;
                        default:
                            System.out.println("Не понимаю, начни с начала");
                            break;
                    }
                }
            }
        }
    }

    public void taskToDay() throws DateTimeParseException {
        System.out.println("Введите дату в формате Год-Месяц-День. Пример:2023-03-08");
        try {
            LocalDate date = LocalDate.parse(scanner.next());
            System.out.println("Здачи на указанный вами день");
            for (Task task : diary) {
                if (task.getDate().isBefore(date)) {
                    if (task.dayTask(date)) {
                        System.out.println(task);
                    }
                }
            }
        }
        catch (DateTimeParseException x){
            System.out.println("Введен неверный формат даты");
        }
    }

    public void addTaskPersonal() {
        System.out.println("Введите заголовок, а потом описание вашей задачи");
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
