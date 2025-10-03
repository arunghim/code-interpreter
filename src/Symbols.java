import java.util.HashMap;
import java.util.Map;

public class Symbols {

    public static Map<String, Integer> initializeSymbols() {
        Map<String, Integer> symbols = new HashMap<>();

        symbols.put(";", 12);
        symbols.put(",", 13);
        symbols.put("=", 14);
        symbols.put("!", 15);
        symbols.put("[", 16);
        symbols.put("]", 17);
        symbols.put("&&", 18);
        symbols.put("||", 19);
        symbols.put("(", 20);
        symbols.put(")", 21);
        symbols.put("+", 22);
        symbols.put("-", 23);
        symbols.put("*", 24);
        symbols.put("!=", 25);
        symbols.put("==", 26);
        symbols.put("<", 27);
        symbols.put(">", 28);
        symbols.put("<=", 29);
        symbols.put(">=", 30);

        return symbols;
    }
}