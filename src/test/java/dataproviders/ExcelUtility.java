package dataproviders;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    public static Object[][] getTestData(String sheetName)
            throws IOException {

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + "/testdata/LoginData.xlsx"
        );

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();

        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = formatter.formatCellValue(
                        sheet.getRow(i).getCell(j)
                );
            }
        }

        workbook.close();

        fis.close();

        return data;
    }
}