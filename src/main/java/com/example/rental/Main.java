package com.example.rental;

import com.example.rental.model.Tool;
import com.example.rental.model.ToolType;
import com.example.rental.service.CheckoutService;
import com.example.rental.service.RentalAgreement;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Sample tool: Ladder from Werner
        Tool tool = new Tool("LADW", ToolType.LADDER, "Werner");

        // Sample checkout inputs
        int rentalDays = 3;
        int discountPercent = 10;
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2);  // Example: 07/02/20

        // Perform checkout
        try {
            RentalAgreement agreement = CheckoutService.checkout(tool, rentalDays, discountPercent, checkoutDate);
            agreement.print();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
