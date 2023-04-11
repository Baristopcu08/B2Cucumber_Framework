package readers.json.Lomboks;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Lombok1 extends Lomboks{
    private String url;
    private String username;
    private String password;
    private List<User> users;

    @Data
    public static class User {
        private String type;
        private boolean valid;
        private String username;
        private String password;
        private Address address;
    }

    @Data
    public static class Address {
        private String street;
        private int number;
        private String city;
    }
}
