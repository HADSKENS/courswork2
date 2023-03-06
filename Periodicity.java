import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public enum Periodicity {
    OnlyOne {
        void nextTimeActuation(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() + 1 == time.getDate() & date1.getMonth() == time.getMonth() & date1.getYear() == time.getYear()) {
                System.out.println(task);
            }
        }

        @Override
        void nextDay(Task task) throws  ParseException{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE,1);
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() + 1 == time.getDate() & date1.getMonth() == time.getMonth() & date1.getYear() == time.getYear()) {
                System.out.println(task);
            }
        }
    },
    OneOnDay {
        void nextTimeActuation(Task task) {
            DailyTask a = (DailyTask) task;
            Calendar cal = Calendar.getInstance();
            Date date1 = a.getDatePreservation();
            Date time = cal.getTime();
            if (date1.getDate() + 1 == time.getDate()) {
                System.out.println(task);
                System.out.println(date1.getDate());
                cal.add(Calendar.DATE, 1);
                System.out.println(cal.getTime());
                a.setDatePreservation(cal.getTime());
            }
        }

        @Override
        void nextDay(Task task) {
            DailyTask a = (DailyTask) task;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            Date date1 = a.getDatePreservation();
            Date time = cal.getTime();
            if (date1.getDate() + 1 == time.getDate()) {
                System.out.println(task);
                System.out.println(date1.getDate());
                cal.add(Calendar.DATE, 1);
                System.out.println(cal.getTime());
                a.setDatePreservation(cal.getTime());
            }
        }
        },
    OneOnWeek {
        void nextTimeActuation(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDay() == time.getDay()) {
                System.out.println(task);
            }
        }

        @Override
        void nextDay(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE,1);
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDay() == time.getDay()) {
                System.out.println(task);
            }
        }
    },
    OneOnMonth {
        void nextTimeActuation(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() == time.getDate()) {
                System.out.println(task);
            }
        }

        @Override
        void nextDay(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE,1);
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() == time.getDate()) {
                System.out.println(task);
            }
        }
    },
    OneOnYear {
        void nextTimeActuation(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() == time.getDate() & date1.getMonth() == time.getMonth()) {
                System.out.println(task);
            }
        }
        void nextDay(Task task) throws ParseException {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE,1);
            String date = task.getDate();
            SimpleDateFormat d2 = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date1 = d2.parse(date);
            Date time = cal.getTime();
            if (date1.getDate() == time.getDate() & date1.getMonth() == time.getMonth()) {
                System.out.println(task);
            }
        }
    };
    abstract  void nextDay(Task task) throws ParseException;

    abstract void nextTimeActuation(Task task) throws ParseException;
}
