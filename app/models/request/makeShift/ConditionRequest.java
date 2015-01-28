package models.request.makeShift;


import java.util.List;

import play.data.validation.Constraints.Required;
import lombok.Data;

@Data
public class ConditionRequest {
	
	@Required
	public String openingTime;
	@Required
	public String closingTime;
	@Required
	public String shiftSystem;
	public List<String> holidays;
	@Required
	public String minRequiredMember;
	
	
}
