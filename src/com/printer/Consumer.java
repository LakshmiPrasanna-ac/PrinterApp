package com.printer;

import com.printer.enums.PrinterType;
import com.printer.model.PrintRequest;
import com.printer.model.Printer;

public class Consumer {

	public static void main(String[] args) {

        PrinterApp manager = new PrinterApp();

        PrintRequest request = new PrintRequest(3, PrinterType.COLOR, 5);

        Printer printer = manager.findPrinter(request);

        if (printer != null) {
            System.out.println("Printer found → Floor: " 
                + printer.getFloor() + ", ID: " + printer.getId());
        } else {
            System.out.println("No printer available");
        }
    }
}
