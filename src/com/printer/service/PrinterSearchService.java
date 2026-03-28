package com.printer.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.printer.constants.PrinterConstants;
import com.printer.model.PrintRequest;
import com.printer.model.Printer;
import com.printer.repository.PrinterRepository;

public class PrinterSearchService {

	private PrinterRepository repository;

	public PrinterSearchService(final PrinterRepository repository) {
		this.repository = repository;
	}
	
	public Printer findPrinter(final PrintRequest request) {
		Printer printerinfo=null;
		List<Printer> printerList = repository.getPrintersByFloor(request.floorId());
		printerinfo = checkPrinters(request, printerList);
		if(printerinfo==null) {
			int up=request.floorId()+1;
			int down=request.floorId()-1;
			while(up<PrinterConstants.MAX_FLOORS && down>0) {
				printerList = repository.getPrintersByFloor(up);
				printerinfo = checkPrinters(request, printerList);
				if(printerinfo!=null) return printerinfo;
				
				printerList = repository.getPrintersByFloor(down);
				printerinfo = checkPrinters(request, printerList);
				if(printerinfo!=null) return printerinfo;
				
				up++;
				down--;
			}
			
			while(up<PrinterConstants.MAX_FLOORS) {
				printerList = repository.getPrintersByFloor(up);
				printerinfo = checkPrinters(request, printerList);
				if(printerinfo!=null) return printerinfo;
				up++;
			}
			
			while(down>0) {
				printerList = repository.getPrintersByFloor(down);
				printerinfo = checkPrinters(request, printerList);
				if(printerinfo!=null) return printerinfo;
				down--;
			}
		}
		return printerinfo;
	}
	
	
	
	private Printer checkPrinters(final PrintRequest request, List<Printer> printerList) {
		List<Printer> validPrinterList = new ArrayList<>();
		for(Printer printer : printerList) {
			if(printer.isAvailable() && isColorValid(request, printer)) {
				validPrinterList.add(printer);
			}
		}
		return validPrinterList.size()>0? selectPrinter(request, validPrinterList) : null;
	}
	
	private boolean isColorValid(final PrintRequest request, final Printer printer) {
		if(request.type()==null || request.type()==printer.getType()) {
				return true;
		}
		return false;
	}
	
	private Printer selectPrinter(final PrintRequest request, final List<Printer> printerList) {
		Printer printer = null;
		printer = printerList.stream().filter(p->p.getPagesPerMin()>=request.noOfPages()).
		min(Comparator.comparing(Printer::getPagesPerMin)).orElse(printer);
		if(printer==null) {
			printer = printerList.stream().max(Comparator.comparing(Printer::getPagesPerMin)).orElse(printer);
		}
		return printer;
	}
}
