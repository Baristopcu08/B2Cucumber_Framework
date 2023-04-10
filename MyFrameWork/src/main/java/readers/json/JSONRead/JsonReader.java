package readers.json.JSONRead;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    public static void main(String[] args) throws FileNotFoundException {
        String file ="src/test/resources/datafiles/configME.json";
        JSONObject parse = (JSONObject) JSONValue.parse(new FileReader(file));
        System.out.println(parse.toJSONString());
    }
}
