package com.printer;

import com.printer.exception.NoAvailablePrinterException;
import com.printer.model.PrintRequest;
import com.printer.model.Printer;
import com.printer.repository.PrinterRepository;
import com.printer.service.PrinterSearchService;
import com.printer.util.PrinterUtil;

public class PrinterApp {
	
	private final PrinterSearchService printerSearchService;

	public  PrinterApp() {
		final PrinterRepository printerRepository = new PrinterRepository();
		printerSearchService = new PrinterSearchService(printerRepository);
	}
	
	public Printer findPrinter(final PrintRequest request) {
		PrinterUtil.validateParams(request);
		Printer printerInfo = printerSearchService.findPrinter(request);
		if(printerInfo==null) {
			throw new NoAvailablePrinterException("No available printer");
		} 
		return printerInfo;
		
	}
	
	

}
