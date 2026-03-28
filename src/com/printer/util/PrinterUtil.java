package com.printer.util;

import com.printer.constants.PrinterConstants;
import com.printer.exception.InvalidRequestException;
import com.printer.model.PrintRequest;

public class PrinterUtil {
	
	private PrinterUtil() {}
	
	public static void validateParams(final PrintRequest request) {
		
		if(request.floorId() <=0 || request.floorId()>PrinterConstants.MAX_FLOORS) {
			throw new InvalidRequestException("Invalid floor Id");
		}
		
		if(request.noOfPages()<=0) {
			throw new InvalidRequestException("Invalid page count");
		}
		
	}

}
