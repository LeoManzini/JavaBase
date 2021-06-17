package br.com.leomanzini.enums;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double valueperHour;
	private Integer hours;
	
	public HourContract() {
	}

	public HourContract(Date date, Double valueperHour, Integer hours) {
		this.date = date;
		this.valueperHour = valueperHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueperHour() {
		return valueperHour;
	}

	public void setValueperHour(Double valueperHour) {
		this.valueperHour = valueperHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public Double totalValue() {
		return valueperHour * hours;
	}
}
