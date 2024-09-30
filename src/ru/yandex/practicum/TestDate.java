package ru.yandex.practicum;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestDate {
    public static final int START_YEAR = 2025;
    public static final int START_DAY = 1;
    public static final int MAX_SHIFT = 8;

    public TestDate() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        printWorkHours(
                8, 30, 8, 5
        );

        LocalDateTime firstStart = LocalDateTime.of(2099, 10, 10, 12, 5);
        LocalDateTime firstEnd = LocalDateTime.of(2099, 10, 10, 14, 15);
        printGap(firstStart, firstEnd);

//        LocalDate birthday = LocalDate.of(1998, 9, 25);
//        LocalDate today = LocalDate.now();
//        LocalDate otherDay = LocalDate.of(2024, 9, 23);
//
//        Period period = Period.between(birthday, today);
//
//        System.out.println(period.getYears());
//
//        LocalTime start = LocalTime.of(0, 0);
//        LocalTime finish = LocalTime.of(1, 30);
//
//        Duration ninetyMinutes = Duration.between(start, finish);
//
//        LocalTime noon = LocalTime.of(12, 0);
//        LocalTime newTime = noon.plus(ninetyMinutes);
//
//        System.out.println(noon);
//        System.out.println(newTime);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        ZoneId zone = ZoneId.of("UTC+3");
        System.out.println(zone);

        ZonedDateTime zdt = ZonedDateTime.of(dateTime, zone);

        System.out.println(zdt);


    }

    private static void printWorkHours(
            int startHours,
            int startMinutes,
            int shiftContinuation,
            int shiftAmount
    ) {
        if (shiftContinuation > MAX_SHIFT) {
            System.out.println("Так много работать ЗАПРЩЕНО");

            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm");
        LocalDateTime currentDate = LocalDateTime.of(START_YEAR, Month.FEBRUARY, START_DAY, startHours, startMinutes);

        for (int i = 0; i < shiftAmount; i++) {
            System.out.print((i+1) + " смена. ");
            System.out.print("Начало: " + currentDate.format(formatter));
            currentDate = currentDate.plusHours(shiftAmount);
            System.out.print(", конец: " + currentDate.format(formatter));
            System.out.println();
        }
    }

    private static void printGap(LocalDateTime start, LocalDateTime end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        System.out.println("Вход в гиперпространство: ");
        System.out.println(start.format(formatter));
        System.out.println("Выход из гиперпространства: ");
        System.out.println(end.format(formatter));

        if (Duration.between(start, end).toDays() >= 1) {
            System.out.println("Дней на гиперпрыжок: " + Duration.between(start, end).toDays());
        } else {
            System.out.println("Минут на гиперпрыжок: " + Duration.between(start, end).toMinutes());
        }
    }

    public String getHi() {
        return "Hi";
    }
}
