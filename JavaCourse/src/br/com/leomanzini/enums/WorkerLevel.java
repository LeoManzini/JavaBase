package br.com.leomanzini.enums;

public enum WorkerLevel {
	
	JUNIOR(1),
	MID_LEVEL(2),
	SENIOR(3);
	
	private int value;
	
	private WorkerLevel(int value) {
	}
	
	public int getValue() {
		return this.value;
	}
}
