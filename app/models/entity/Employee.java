package models.entity;

import java.util.List;

import lombok.Data;

@Data
public class Employee {

	public String name;
	public List<String> desirableHolidays;
	public PersonalShift shift;

}
