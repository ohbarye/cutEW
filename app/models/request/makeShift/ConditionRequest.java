package models.request.makeShift;


import java.util.List;

import play.data.validation.Constraints.Required;
import lombok.Data;
import models.entity.Employee;

@Data
public class ConditionRequest {
	
	@Required
	public String openingTime;
	@Required
	public String closingTime;
	@Required
	public String shiftSystem;
	@Required
	public String minRequiredMember;

	public List<Employee> employees;
	
}
