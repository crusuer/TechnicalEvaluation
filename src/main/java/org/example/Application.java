package org.example;

import org.example.service.PriceService;

import java.util.Scanner;

public class Application {

    private static final PriceService service = new PriceService();
    private static final String END_PROGRAM_COMMAND = "quit";

    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
            String line;
            do {
                System.out.print("Basket: ");
                line = keyboard.nextLine();
                System.out.println("Total price expected: \u00a3" + service.getPrice(line.split(",")));
            } while (!line.equals(END_PROGRAM_COMMAND));
        }
    }
}
