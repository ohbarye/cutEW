package models.request.makeShift;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ConfigUtil;

public class ConditionChoices {

	public static List<String> startTimeHh = ConfigUtil.getList("start.time.hour").get();
	public static List<String> endTimeHh = ConfigUtil.getList("end.time.hour").get();
	public static List<String> timeMm = ConfigUtil.getList("time.minutes").get();
	public static Map<String,String> shiftSystem = new HashMap<>();
	static {
		
	}

}
