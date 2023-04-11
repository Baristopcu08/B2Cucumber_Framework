package readers.json.Lomboks;

import lombok.Data;

import java.util.List;

@Data
public class Lombok3 extends Lomboks{

    private List<User> users;

    @Data
    public static class User {
        private int id;
        private String usertype;
        private String name;
        private String lastname;
    }
}
