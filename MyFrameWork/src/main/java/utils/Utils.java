package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    /**
     * takescreenshots
     */
    public static void takeScreenShot(){
        takeScreenShot("screenshot");
    }

    /**
     * sayfanin ekran kaydini almak icin kullanilir
     * @param fileName filename of the screenshot
     */
    public static void takeScreenShot(String fileName){
        fileName = fileName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "test-output/screenshots/" + fileName + ".png";
        TakesScreenshot scrShot =((TakesScreenshot) Driver.getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * bir elementin resmini kaydetmek icin kullanilir
     * @param fileName filename of the screenshot of an element
     */
    public static void takeScreenShotOfElement(WebElement element, String fileName){
        fileName = fileName + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String filePath = "test-output/screenshots/" + fileName + ".png";
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * alinan screenshot'i byte[] olarak return eder
     * @return screenshot in byte[]
     */
    public static byte[] getScreenShotAsByte(){
        return  ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * create directory if not exist
     * @param fileWithPath
     */
    public static void createDirectory(String fileWithPath){
        String[] pathArray = fileWithPath.split("/");
        String path = "";
        if (pathArray.length>0) {
            for (int i = 0; i < pathArray.length - 1; i++) {
                path += pathArray[i] + "/";
            }
        }
        File theDir = new File(path);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }

    /**
     * java sleep
     * @param millis milliseconds
     */
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static By getBy(String main, String sub) throws FileNotFoundException {
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        JSONObject mainNode = (JSONObject) object.get(main);
        JSONObject subNode = (JSONObject) mainNode.get(sub);

        String type = subNode.get("type").toString();
        String locator = subNode.get("locator").toString();

        switch (type.toLowerCase()){
            case "xpath" : return By.xpath(locator);
            case "css" : return By.cssSelector(locator);
            case "id" : return By.id(locator);
            case "tagname" : return By.tagName(locator);
            case "classname" : return By.className(locator);
            case "linktext" : return By.linkText(locator);
            case "partiallinktext" : return By.partialLinkText(locator);
            default: return null;
        }
    }

    public static String getValue(String main, String key) throws FileNotFoundException {
        String jsonFile = "src/test/resources/datafiles/Elements.json";

        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(jsonFile));

        JSONObject mainNode = (JSONObject) object.get(main);
        return mainNode.get(key).toString();

    }

    /**
     *
     * @param path hem json hem yaml okuyabilir
     * @param tClass
     * @return
     * @param <T>
     * @throws IOException
     */
    public static <T> T readConfig(String path, Class<T> tClass) throws IOException {

        if (path.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            try (FileReader reader = new FileReader(path)) {
                return mapper.readValue(reader, tClass);
            }
        } else if (path.endsWith(".yaml") || path.endsWith(".yml")) {
            Yaml yaml = new Yaml();
            try (FileReader reader = new FileReader(path)) {
                return yaml.loadAs(reader, tClass);
            }
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + path);
        }
    }

    public static boolean isFileExist(String fileWithPath){
        File f = new File(fileWithPath);
        return f.exists() && !f.isDirectory();
    }
}
