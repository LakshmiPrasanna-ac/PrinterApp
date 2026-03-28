package com.printer.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.printer.enums.PrinterType;
import com.printer.model.Printer;

public class PrinterRepository {

	private Map<Integer, List<Printer>> floorPrinterData = new HashMap<>();

	public PrinterRepository() {
		loadData();
	}

	private void loadData() {
		floorPrinterData.put(1, List.of(
				new Printer(1, 1, PrinterType.BLACK_AND_WHITE, 20, true),
				new Printer(2, 1, PrinterType.COLOR, 15, true),
				new Printer(3, 1, PrinterType.COLOR, 8, true)));
		floorPrinterData.put(3, List.of(
				new Printer(3, 3, PrinterType.BLACK_AND_WHITE, 20, true),
				new Printer(4, 3, PrinterType.COLOR, 15, true)));
		floorPrinterData.put(5, List.of(
				new Printer(5, 5, PrinterType.BLACK_AND_WHITE, 20, true),
				new Printer(6, 5, PrinterType.COLOR, 15, true)));
	}

	public List<Printer> getPrintersByFloor(int floor) {
		return floorPrinterData.getOrDefault(floor, new ArrayList<>());
	}
}
