package GeneriUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public String ReadData(String sname, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet(sname).getRow(row).getCell(cell).getStringCellValue();
	}
}
