package readers.json.Lomboks;

import lombok.Data;
import java.util.Map;

@Data
public class Lombok2 extends Lomboks {
    private Map<String, User> users;

    @Data
    public static class User {
        private String name;
        private String lastname;
    }
}
