package models.request.makeShift;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ConfigUtil;

public class ConditionChoices {

	public static List<String> stageNum = ConfigUtil.getList("stage.num").get();
	public static Map<String,String> shiftSystem = new HashMap<>();
	static {
		
	}

}
