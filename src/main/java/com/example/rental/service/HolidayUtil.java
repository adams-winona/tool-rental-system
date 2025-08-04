package com.example.rental.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayUtil {

    public static boolean isHoliday(LocalDate date) {
        return isIndependenceDay(date) || isLaborDay(date);
    }

    private static boolean isIndependenceDay(LocalDate date) {
        int year = date.getYear();
        LocalDate july4 = LocalDate.of(year, 7, 4);
        if (july4.getDayOfWeek() == DayOfWeek.SATURDAY) {
            july4 = july4.minusDays(1);
        } else if (july4.getDayOfWeek() == DayOfWeek.SUNDAY) {
            july4 = july4.plusDays(1);
        }
        return date.equals(july4);
    }

    private static boolean isLaborDay(LocalDate date) {
        return date.getMonthValue() == 9 &&
                date.getDayOfWeek() == DayOfWeek.MONDAY &&
                date.getDayOfMonth() <= 7;
    }
}
