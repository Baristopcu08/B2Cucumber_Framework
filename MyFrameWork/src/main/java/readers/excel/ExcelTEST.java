package readers.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTEST {

    String file;
    FileInputStream fileInputStream;
    Workbook workbook;
    Sheet sheet;


    @Test
    public void read1() throws IOException {
        file="src/test/resources/datafiles/ExcelB.xlsx";
        fileInputStream=new FileInputStream(file);
        workbook= WorkbookFactory.create(fileInputStream);
        sheet=workbook.getSheetAt(0);
        int cauntRow = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < cauntRow; i++) {
            Row row=sheet.getRow(i);
            int cauntCell = row.getPhysicalNumberOfCells();

            for (int i1 = 0; i1 < cauntCell; i1++) {
                Cell cell = row.getCell(i1);
                System.out.print(cell+ "\t");

            }
            System.out.println();
        }

        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void getRowValue() throws IOException {
        String file="src/test/resources/datafiles/ExcelB.xlsx";
        getRowValuesOf(file, "person", 2).forEach(i-> System.out.print(i+"\t"));

    }

    @Test
    public void test2() throws IOException {
        String file="src/test/resources/datafiles/ExcelB.xlsx";
        getColValuesOf(file,"person",5).forEach(System.out::println);
    }



    public List<String> getColValuesOf(String fileName, String page, int colNumber) throws IOException {
        List<String> list=new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("person");
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            String cell = sheet.getRow(i).getCell(colNumber).toString();
            list.add(cell);
        }
        workbook.close();
        fileInputStream.close();;
        return list;
    }



    private List<String> getRowValuesOf(String fileName, String page, int indexOfRow) throws IOException {
        List<String> list=new ArrayList<>();

        FileInputStream fileInputStream=new FileInputStream(fileName);
        workbook= WorkbookFactory.create(fileInputStream);
        int cauntCell = workbook.getSheet("person").getRow(indexOfRow).getPhysicalNumberOfCells();

        for (int i = 0; i < cauntCell; i++) {
            String person = workbook.getSheet("person").getRow(indexOfRow).getCell(i).toString();
            list.add(person);
        }
        workbook.close();
        fileInputStream.close();;
        return list;
    }
}

