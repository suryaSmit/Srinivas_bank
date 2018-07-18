package resources;

import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Excel {


	public static Object[][] readExcelData(String fileName, String sheetName) {
		Object[][] data = null;
		try {
			InputStream fis = Excel.class.getClassLoader().getResourceAsStream("resources/" + fileName);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			XSSFSheet sh = book.getSheet(sheetName);
			XSSFRow row = sh.getRow(0);
			XSSFCell cell;
			data = new Object[sh.getLastRowNum()][row.getLastCellNum()];
			for (int i = 1; i <= sh.getLastRowNum(); i++) {
				row = sh.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					switch (cell.getCellTypeEnum()) {
					case NUMERIC:
						int d = (int)cell.getNumericCellValue();
						data[i-1][j] = Integer.toString(d);
						break;
					case STRING:
						data[i - 1][j] = cell.getStringCellValue();
						break;
					default:
						data[i-1][j] = 0;
						break;
					}

				}
			}
			book.close();
			fis.close();

			return data;
		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

}
