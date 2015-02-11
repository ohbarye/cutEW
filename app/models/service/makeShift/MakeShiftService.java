package models.service.makeShift;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import models.entity.Employee;
import models.request.makeShift.ConditionRequest;
import net.sf.jett.transform.ExcelTransformer;

/**
 * シフト作成のServicクラス
 * @author ohbarye
 */
public class MakeShiftService {
	
	/** シフト表テンプレートのパス */
	private static final String templatePath = "resources/shift_template.xlsx";
	/** シフト表出力先 */
	private static final String outPath = "resources/shift.xlsx";

	/**
	 * 帳票作成処理
	 * @param condition
	 * @return
	 */
	public static File makeShift(ConditionRequest condition) {
		
		try (FileOutputStream fileOut = new FileOutputStream(outPath);
			 InputStream fileIn       = new BufferedInputStream(new FileInputStream(templatePath))) {

			ExcelTransformer transformer = new ExcelTransformer();
			Workbook workbook = transformer.transform(fileIn, createParams(condition));
			workbook.write(fileOut);
			fileOut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			// TODO
		}
		
		return new File(outPath);
	}
	
	/**
	 * 帳票テンプレートに渡すパラメータを作成する
	 * @param condition
	 * @return
	 */
	private static Map<String, Object> createParams(ConditionRequest condition) {
		
		Map<String, Object> params = Maps.newHashMap();

		List<Employee> employees = condition.employees;
		params.put("employees", employees);
		params.put("openingTime", condition.openingTime);
		params.put("closingTime", condition.closingTime);
		
		return params;
	}
}
