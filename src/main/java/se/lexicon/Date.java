package se.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date {
    public static void exercise1() {
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);
    }

    public static void exercise2() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("eeee dd MMMM"));
        System.out.println(date);
    }

    public static void exercise3() {
        int day = 3;
        for (int i = 0; i < 7; i++) {
            LocalDate date = LocalDate.of(2023, 7, day);
            day++;
            System.out.println(date.format(DateTimeFormatter.ISO_DATE));
        }
    }

    public static void exercise4() {
        LocalDate date = LocalDate.parse("2023-07-10");
        System.out.println(date);
    }

    public static DayOfWeek exercise5() {
        LocalDate date = LocalDate.of(1945, 5, 8);
        return date.getDayOfWeek();
    }

    public static void exercise6() {
        LocalDate date = LocalDate.now().plusYears(10).minusMonths(10);
        System.out.println(date);
    }

    public static void exercise7() {
        LocalDate date = LocalDate.of(1945, 5, 8);
        LocalDate birthday = LocalDate.of(1984, 1, 2);
        Period period = Period.between(date, birthday);
        System.out.println("Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
    }

    public static void exercise8() {
        Period period = Period.of(4, 7, 29);
        LocalDate date = LocalDate.now();
        System.out.println(date.plus(period));
    }

    public static void exercise9() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }

    public static void exercise10() {
        LocalTime time = LocalTime.now();
        System.out.println(time.getNano());
    }

    public static void exercise11() {
        LocalTime time = LocalTime.parse("15:41:12");
        System.out.println(time);
    }

    public static void exercise12() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time);
    }

    public static void exercise13() {
        String timeAndDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("'date: 'y'-'MM'-'dd', time: 'HH:mm"));
        System.out.println(timeAndDate);
    }

    public static void exercise14() {
        LocalDateTime dayAndTime = LocalDateTime.parse("2023-07-10T10:00");
        String dayAndTimeFormatted = dayAndTime.format(DateTimeFormatter.ofPattern("eeee d MMMM HH:mm"));
        System.out.println(dayAndTimeFormatted);
    }

    public static void exercise15() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        System.out.println(date + "T" + time);
    }

    public static void exercise16() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("LocalDateTime object:\t" + localDateTime + "\nLocalDate object:\t\t" + localDate + "\nLocalTime object\t\t" + localTime);
    }

    public static void extraAssignment() {
        String prevMonth = "";
        String month;
        int tabs;

        System.out.println("\n\n2018 Calendar");

        for (int i = 0; i <= 365; i++) {
            LocalDate localDate = LocalDate.of(2018, 1, 1).plusDays(i);
            month = String.valueOf(localDate.getMonth());
            if (!Objects.equals(month, prevMonth)) { // As suggested by intelliJ
                System.out.println("\n\n" + month);
                System.out.print("Monday\t\tTuesday\t\tWednesday\tThursday\tFriday\t\tSaturday\tSunday\t\t");
                tabs = i % 7;
                System.out.println(); // I need this for some reason, otherwise the dayOfMonth are placed weirdly
                while (tabs > 0) {
                    System.out.print("\t\t\t");
                    tabs--;
                }
            }
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(localDate.getDayOfMonth() + "\t\t\t");
            prevMonth = month;
        }
    }
}