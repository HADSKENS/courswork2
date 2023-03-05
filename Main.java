import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static Diary a = new Diary();
    static Scanner in = new Scanner(System.in);

    public static void printMenu() {
        System.out.println();
        System.out.println("1 - создать личную задачу");
        System.out.println("2 - создать рабочую задачу");
        System.out.println("3 - напичатать все задачи");
        System.out.println("4 - удалить задачу по id");
        System.out.println("5 - задачи на текущий день");
        System.out.println("6 - напчатать архив удаленных задач");
        System.out.println("7 - отредактировать задачу по id");
        System.out.println();
    }

    public static void menuChoice(int numMenu) throws ParseException {
        switch (numMenu) {
            case 1:
                a.addTaskPersonal();
                printMenu();
                break;
            case 2:
                a.addTaskWorking();
                printMenu();
                break;
            case 3:
                a.printAll();
                printMenu();
                break;
            case 4:
                a.deleteTaskIfHaveId();
                printMenu();
                break;
            case 5:
                a.taskNextDay();
                printMenu();
                break;
            case 6:
                a.printArchive();
                printMenu();
                break;
            case 7:
                a.editTask();
                printMenu();
                break;
            default:
                System.out.println("Не понимаю");
                printMenu();
                break;
        }
    }

    public static void main(String[] args) throws ParseException{
        printMenu();
        while (in.hasNext()) {
            menuChoice(in.nextInt());
        }
    }
}