package br.com.leomanzini.enums;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		setName(name);
		setLevel(level);
		setBaseSalary(baseSalary);
		setDepartment(department);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}
	
	public Double income(Integer year, Integer month) {
		double sum = this.baseSalary;
		Calendar calendar = Calendar.getInstance();
		
		for(HourContract contract : this.contracts) {
			
			calendar.setTime(contract.getDate());
			int c_year = calendar.get(Calendar.YEAR);
			int c_month = 1 + calendar.get(Calendar.MONTH);
			
			if(year == c_year && month == c_month) {
				sum +=contract.totalValue();
			}
		}
		
		return sum;
	}
}
