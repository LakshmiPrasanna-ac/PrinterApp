package com.printer.model;

import com.printer.enums.PrinterType;

public class Printer {
	private int id;
	private int floor;
	private PrinterType type;
	private int pagesPerMin;
	private boolean available;
	
	public Printer() {
	}

	public Printer(int id, int floor, PrinterType type, int pagesPerMin, boolean available) {
		super();
		this.id = id;
		this.floor = floor;
		this.type = type;
		this.pagesPerMin = pagesPerMin;
		this.available = available;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public PrinterType getType() {
		return type;
	}

	public void setType(PrinterType type) {
		this.type = type;
	}

	public int getPagesPerMin() {
		return pagesPerMin;
	}

	public void setPagesPerMin(int pagesPerMin) {
		this.pagesPerMin = pagesPerMin;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Printer [id=" + id + ", floor=" + floor + ", type=" + type + ", pagesPerMin=" + pagesPerMin
				+ ", available=" + available + "]";
	}

}
