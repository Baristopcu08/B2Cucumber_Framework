package readers.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReadWriteAppend_ME {

    FileInputStream fileInputStream;

    @Test
    public void readExcel() throws IOException {
        // okunacak excel dosyasi
        String file = "src/test/resources/datafiles/ExcelA.xlsx";

        // javanin dosyayi okumasi icin
        FileInputStream fileInputStream = new FileInputStream(file);

        // okunan dosya excel sayfasi olarak belirlendi
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Okunacak sayfa belirlendi
        Sheet sheet = workbook.getSheetAt(0);   // ilk sayfa acilir
        //Sheet sheet = workbook.getSheet("Sheet1");  // "Sheet1" sayfasi acilir


        // sheet icindeki olusturulmus row sayisini verir
        int lastRow = sheet.getPhysicalNumberOfRows();

        // sheet icindeki row okunur
        Row row = sheet.getRow(0);

        // row icindeki hücre sayisini verir
        int lastCell = row.getPhysicalNumberOfCells();

        // row icindeki cell okunur
        Cell cell = row.getCell(0);
        System.out.println(cell);

        cell = row.getCell(1);
        System.out.println(cell);

        cell = row.getCell(2);
        System.out.println(cell);

        workbook.close();
        fileInputStream.close();

    }

    @Test
    public void writeNewExcelFile() throws IOException {
        //ram'da bir excel wordbook oluşturuldu
        XSSFWorkbook workbook = new XSSFWorkbook(); // xlsx için
        //HSSFWorkbook workbook1=new HSSFWorkbook(); //xls için

        //WorkBook'da bir sheet açıldı
        XSSFSheet sheet = workbook.createSheet("sayfam");

        //Sheet içine ilk row ve aynı row içine bir cell oluşturuldu
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);

        //cell'e değer atandı
        cell.setCellValue("GuiderSoft");
        String file = "src/test/resources/datafiles/ExcelYeni.xlsx";
        FileOutputStream fileInputStream = new FileOutputStream(file);
        workbook.write(fileInputStream);
        workbook.close();
        fileInputStream.close();

    }

    @Test
    public void WriteExcelMap() throws IOException {
        Map<String, String> data1 = new HashMap<>();
        data1.put("Adi", "Ali");
        data1.put("soyadi", "Veli");
        data1.put("yaşı", "40");

        String file = "src/test/resources/datafiles/ExcelMap.xlsx";
        writeMapToExcel(data1, file, "yeniSayfa");
    }

    public static void writeMapToExcel(Map<String, String> dataMap, String filePath, String sheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        int rowCount = 0;

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            XSSFRow row = sheet.createRow(rowCount);
            Cell keyCell = row.createCell(0);
            keyCell.setCellValue(entry.getKey());
            keyCell.setCellStyle(style);
            Cell valueCell = row.createCell(1);
            valueCell.setCellValue(entry.getValue());
            valueCell.setCellStyle(style);
            rowCount++;
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
    }

    @Test
    public void writeexcell() throws IOException {
        List<List<String>> names = new ArrayList<>();
        names.add(Arrays.asList("adi", ":", "Ali"));
        names.add(Arrays.asList("soyadi", ":", "Veli"));
        String file = "src/test/resources/datafiles/Excel_3_Satırlı.xlsx";
        writeExcell(file, names);
    }

    private void writeExcell(String filePath, List<List<String>> list) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        FileOutputStream outputStream = new FileOutputStream(filePath);

        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(list.get(i).get(j));
            }
        }
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    @Test
    public void Test() throws IOException {
        List<List<String>> sonuclar = uclerCarpimTablosu();
        String file = "src/test/resources/datafiles/Excel_4_çarpım_tablosu.xlsx";
        writeExcell(file, sonuclar);
    }

    public static List<List<String>> uclerCarpimTablosu() {
        int sayi = 3;
        List<List<String>> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            List<String> herBirSatir = new ArrayList<>();
            herBirSatir.add(String.valueOf(i));
            herBirSatir.add("x");
            herBirSatir.add(String.valueOf(sayi));
            herBirSatir.add("=");
            int carpimsonucu = sayi * i;
            herBirSatir.add(String.valueOf(carpimsonucu));
            list.add(herBirSatir);
        }
        return list;
    }








}
