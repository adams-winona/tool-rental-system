package com.example.rental.service;

import com.example.rental.exception.RentalValidationException;
import com.example.rental.model.Tool;
import com.example.rental.model.ToolType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class CheckoutService {

    public static RentalAgreement checkout(Tool tool, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        if (rentalDays < 1)
            throw new RentalValidationException("Rental days must be at least 1");
        if (discountPercent < 0 || discountPercent > 100)
            throw new RentalValidationException("Discount must be between 0 and 100");

        LocalDate dueDate = checkoutDate.plusDays(rentalDays);
        double dailyCharge = getDailyCharge(tool.getType());
        int chargeDays = calculateChargeDays(tool.getType(), checkoutDate, dueDate);
        double preDiscount = round(chargeDays * dailyCharge);
        double discountAmount = round(preDiscount * discountPercent / 100.0);
        double finalCharge = round(preDiscount - discountAmount);

        return new RentalAgreement(tool, rentalDays, checkoutDate, dueDate, dailyCharge, chargeDays,
                preDiscount, discountPercent, discountAmount, finalCharge);
    }

    private static double getDailyCharge(ToolType type) {
        return switch (type) {
            case LADDER -> 1.99;
            case CHAINSAW -> 1.49;
            case JACKHAMMER -> 2.99;
        };
    }

    private static int calculateChargeDays(ToolType type, LocalDate start, LocalDate end) {
        int days = 0;
        for (LocalDate date = start.plusDays(1); !date.isAfter(end); date = date.plusDays(1)) {
            boolean isWeekend = Set.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).contains(date.getDayOfWeek());
            boolean isHoliday = HolidayUtil.isHoliday(date);
            boolean chargeable = switch (type) {
                case LADDER -> !(isHoliday);
                case CHAINSAW -> !(isWeekend);
                case JACKHAMMER -> !(isWeekend || isHoliday);
            };
            if (chargeable) days++;
        }
        return days;
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
