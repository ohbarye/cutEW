package models.request.makeShift;


import lombok.Data;

@Data
public class ConditionRequest {
	
	private String startTimeHh;
	private String startTimeMm;
	private String endTimeHh;
	private String endTimeMm;
	private String shiftSystem;
	private String[] holidays;
	private String minRequiredMember;
	
	
}
