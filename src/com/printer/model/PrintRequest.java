package com.printer.model;

import com.printer.enums.PrinterType;

public record PrintRequest(
		int floorId, 
		PrinterType type,
		int noOfPages) {

}
