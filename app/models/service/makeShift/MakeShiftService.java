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
import net.sf.jett.transform.ExcelTransformer;

/**
 * シフト作成のServicクラス
 * @author ohbarye
 */
public class MakeShiftService {

	public static File makeShift() {
		System.out.println(System.getProperty("user.dir"));
		
		List<Employee> employees = Lists.newArrayList();
		
		Map<String, Object> beans = Maps.newHashMap();
		Employee emp = new Employee();
		emp.name = "レミ";
		emp.skillLevel = "一人前";
		
		employees.add(emp);
		
		beans.put("employees", employees);
		
		String inPath  = "resources/shift_template.xlsx";
		String outPath = "resources/shift.xlsx";
		
		try (FileOutputStream fileOut = new FileOutputStream(outPath);
			 InputStream fileIn       = new BufferedInputStream(new FileInputStream(inPath))) {

			ExcelTransformer transformer = new ExcelTransformer();
			Workbook workbook = transformer.transform(fileIn, beans);
			workbook.write(fileOut);
			fileOut.close();
			
		} catch (IOException e) {
			System.err.println("IOException reading " + inPath + ": " + e.getMessage());
		} catch (InvalidFormatException e) {
			System.err.println("InvalidFormatException reading " + inPath + ": " + e.getMessage());
		}
		
		return new File(outPath);		
	}
}
