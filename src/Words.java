import java.util.HashMap;
import java.util.Map;

public class Words {

    public static Map<String, Integer> initialize() {
        Map<String, Integer> tokens = new HashMap<>();

        tokens.put("program", 1);
        tokens.put("begin", 2);
        tokens.put("end", 3);
        tokens.put("int", 4);
        tokens.put("if", 5);
        tokens.put("then", 6);
        tokens.put("else", 7);
        tokens.put("while", 8);
        tokens.put("loop", 9);
        tokens.put("read", 10);
        tokens.put("write", 11);

        return tokens;
    }
}