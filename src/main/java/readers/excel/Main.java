package readers.excel;

public class Main {

    public static void main(String[] args) {

        ExcelReader excelReader=new ExcelReader("src/test/resources/datafiles/Myexcel.xlsx");
        excelReader.writeData();


        excelReader.setHeader("Adı","Soyadı");
        excelReader.writeData("a","b");
        excelReader.close();

    }
}
