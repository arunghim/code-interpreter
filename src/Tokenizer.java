import java.io.*;
import java.util.*;

public class Tokenizer {

    private final Map<String, Integer> words, symbols;
    private final List<String> tokens = new ArrayList<>();
    private int pointer = 0;

    public Tokenizer(String filePath) {
        words = Tokens.initializeWords();
        symbols = Symbols.initializeSymbols();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = reader.readLine()) != null; ) {
                for (int i = 0; i < line.length(); ) {
                    char currChar = line.charAt(i);

                    if (Character.isWhitespace(currChar)) {
                        i++;
                        continue;
                    }

                    if (i + 1 < line.length()) {
                        String twoCharSymbol = line.substring(i, i + 2);
                        if (symbols.containsKey(twoCharSymbol)) {
                            tokens.add(twoCharSymbol);
                            i += 2;
                            continue;
                        }
                    }

                    String singleCharSymbol = String.valueOf(currChar);
                    if (symbols.containsKey(singleCharSymbol)) {
                        tokens.add(singleCharSymbol);
                        i++;
                        continue;
                    }

                    if (Character.isLetter(currChar) || currChar == '_') {
                        int start = i;
                        while (i < line.length() && (Character.isLetterOrDigit(line.charAt(i)) || line.charAt(i) == '_')) {
                            i++;
                        }
                        tokens.add(line.substring(start, i));
                        continue;
                    }

                    if (Character.isDigit(currChar)) {
                        int start = i;
                        while (i < line.length() && Character.isDigit(line.charAt(i))) {
                            i++;
                        }
                        tokens.add(line.substring(start, i));
                        continue;
                    }

                    tokens.add("---");
                    i++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getToken() {
        if (pointer >= tokens.size()) {
            return 33;
        }
        String currToken = tokens.get(pointer);
        if (currToken.equals("---")) {
            return 34;
        }
        if (words.containsKey(currToken)) {
            return words.get(currToken);
        }
        if (symbols.containsKey(currToken)) {
            return symbols.get(currToken);
        }
        if (currToken.chars().allMatch(Character::isDigit)) {
            return 31;
        }
        if (Character.isLetter(currToken.charAt(0)) || currToken.charAt(0) == '_') {
            return 32;
        }
        return 34;
    }

    public void skipToken() {
        if (getToken() != 33) {
            pointer++;

        }
    }

    public int intVal() {
        return Integer.parseInt(tokens.get(pointer));
    }

    public String idName() {
        return tokens.get(pointer);
    }
}