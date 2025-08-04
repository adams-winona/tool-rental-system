package com.example.rental;

import com.example.rental.model.Tool;
import com.example.rental.model.ToolType;
import com.example.rental.service.CheckoutService;
import com.example.rental.service.RentalAgreement;
import com.example.rental.exception.RentalValidationException;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ToolRentalTests {

    @Test
    void test1_invalidDiscount() {
        Tool tool = new Tool("JAKR", ToolType.JACKHAMMER, "Ridgid");
        LocalDate checkoutDate = LocalDate.of(2015, 9, 3);
        assertThrows(RentalValidationException.class, () ->
            CheckoutService.checkout(tool, 5, 101, checkoutDate));
    }

    @Test
    void test2_ladderCheckout() {
        Tool tool = new Tool("LADW", ToolType.LADDER, "Werner");
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2);
        RentalAgreement agreement = CheckoutService.checkout(tool, 3, 10, checkoutDate);
        assertEquals("LADW", agreement.tool.getCode());
    }

    @Test
    void test3_chainsawCheckout() {
        Tool tool = new Tool("CHNS", ToolType.CHAINSAW, "Stihl");
        LocalDate checkoutDate = LocalDate.of(2015, 7, 2);
        RentalAgreement agreement = CheckoutService.checkout(tool, 5, 25, checkoutDate);
        assertEquals("CHNS", agreement.tool.getCode());
    }

    @Test
    void test4_jackhammerDewalt() {
        Tool tool = new Tool("JAKD", ToolType.JACKHAMMER, "DeWalt");
        LocalDate checkoutDate = LocalDate.of(2015, 9, 3);
        RentalAgreement agreement = CheckoutService.checkout(tool, 6, 0, checkoutDate);
        assertEquals("JAKD", agreement.tool.getCode());
    }

    @Test
    void test5_jackhammerRidgidLong() {
        Tool tool = new Tool("JAKR", ToolType.JACKHAMMER, "Ridgid");
        LocalDate checkoutDate = LocalDate.of(2015, 7, 2);
        RentalAgreement agreement = CheckoutService.checkout(tool, 9, 0, checkoutDate);
        assertEquals("JAKR", agreement.tool.getCode());
    }

    @Test
    void test6_jackhammerRidgidShort() {
        Tool tool = new Tool("JAKR", ToolType.JACKHAMMER, "Ridgid");
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2);
        RentalAgreement agreement = CheckoutService.checkout(tool, 4, 50, checkoutDate);
        assertEquals("JAKR", agreement.tool.getCode());
    }
}
