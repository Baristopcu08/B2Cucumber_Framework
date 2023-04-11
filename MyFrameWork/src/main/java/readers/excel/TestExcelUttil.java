package readers.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestExcelUttil {

    @Test
    public void readexcel() throws IOException {

    String excelPath="src/test/resources/datafiles/ExcelA.xlsx";

        FileInputStream fileInputStream=new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Sheet sheet1=workbook.getSheetAt(0); // index olarak
        Sheet sheet=workbook.getSheet("Sheet1");

        int lastrow = sheet.getPhysicalNumberOfRows(); //en son hangi satıra kadar kayıt yapılmış.

        Row row=sheet.getRow(0);
        int lastCell = row.getPhysicalNumberOfCells();// row içindeki hücre sayısını verir
        Cell cell = row.getCell(0);
        System.out.println(cell);

        workbook.close();
        fileInputStream.close();
    }
}
