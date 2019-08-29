package sram.springmvc.lesson06.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;
@Component
public class Emplyee {
	
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	
	@NumberFormat(style=Style.CURRENCY)
	private Float salary;
	
	@NumberFormat(style=Style.PERCENT)
	private Integer precent;
	
	@NumberFormat(pattern="#,###.##")
	private Float num;

	public Emplyee() {
		super();
	}

	public Emplyee(String name, Date hireDate, Float salary, Integer precent, Float num) {
		super();
		this.name = name;
		this.hireDate = hireDate;
		this.salary = salary;
		this.precent = precent;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Integer getPrecent() {
		return precent;
	}

	public void setPrecent(Integer precent) {
		this.precent = precent;
	}

	public Float getNum() {
		return num;
	}

	public void setNum(Float num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Emplyee [name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + ", precent=" + precent
				+ ", num=" + num + "]";
	}
	
}
