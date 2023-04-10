package readers.json.JSONRead;



import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestJsonRead {

    public static void main(String[] args) throws FileNotFoundException {
        String file ="src/test/resources/datafiles/Config11.json";
        JSONObject parse = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(parse);
    }

    @Test
    public void test() throws Exception {

        String file ="src/test/resources/datafiles/configMe.json";
        JSONObject parse = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(parse);

        //yada


    }
}
