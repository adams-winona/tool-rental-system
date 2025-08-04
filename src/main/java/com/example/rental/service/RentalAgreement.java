package com.example.rental.service;


import com.example.rental.model.Tool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;

public class RentalAgreement {
    public Tool tool;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private int discountPercent;
    private double discountAmount;
    private double finalCharge;

    public RentalAgreement(Tool tool, int rentalDays, LocalDate checkoutDate,
                           LocalDate dueDate, double dailyCharge, int chargeDays,
                           double preDiscountCharge, int discountPercent,
                           double discountAmount, double finalCharge) {
        this.tool = tool;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyCharge = dailyCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public void print() {
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("MM/dd/yy");
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println("Tool code: " + tool.getCode());
        System.out.println("Tool type: " + tool.getType());
        System.out.println("Tool brand: " + tool.getBrand());
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Checkout date: " + checkoutDate.format(dateFmt));
        System.out.println("Due date: " + dueDate.format(dateFmt));
        System.out.println("Daily rental charge: " + currencyFmt.format(dailyCharge));
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charge: " + currencyFmt.format(preDiscountCharge));
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Discount amount: " + currencyFmt.format(discountAmount));
        System.out.println("Final charge: " + currencyFmt.format(finalCharge));
    }
}
