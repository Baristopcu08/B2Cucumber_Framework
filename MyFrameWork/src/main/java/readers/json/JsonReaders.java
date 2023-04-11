package readers.json;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import readers.json.Lomboks.Lombok1;
import readers.json.Lomboks.Lombok2;
import readers.json.Lomboks.Lombok3;
import readers.json.Lomboks.Lomboks;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonReaders {
    List<JsonObject> jsonObjects = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {
        String lombok1Path="MyFrameWork/src/test/resources/datafiles/configME2.json";
        String lombok2Path="MyFrameWork/src/test/resources/datafiles/configME3.json";
        String lombok3Path="MyFrameWork/src/test/resources/datafiles/configME4.json";

        Lomboks lombok = getLombok(new Lombok1(), lombok1Path);
        Lomboks lombok2 = getLombok(new Lombok2(), lombok2Path);
        Lombok3 lombok3 = (Lombok3) getLombok(new Lombok3(), lombok3Path);

    }


    /**
     * @param lombok Abstract Lomblok extend eden tüm classları kabul edebilir
     * @param jsonPathofLombokClass okunacak json dosyasının yolu(Projeden itibaren)
     * @return Lomboks abstrack return eder. arguman olarak verilen classa cast etmek gerekir
     * @throws FileNotFoundException
     */
    public static Lomboks getLombok(Lomboks lombok, String jsonPathofLombokClass) throws FileNotFoundException {

        return new Gson().fromJson(new FileReader(jsonPathofLombokClass), lombok.getClass());
    }

}
