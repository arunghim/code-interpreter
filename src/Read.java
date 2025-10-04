import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Read implements ICore {
    private static Scanner input;
    private final Tokenizer tokenizer;
    private final Parser parser;
    private String idName;

    public Read(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        if (input == null) {
            try {
                input = new Scanner(new FileReader(parser.data()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException("ERROR: FAILED TO READ FROM DATA FILE", e);
            }
        }
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() != Types.ID) throw new RuntimeException("ERROR: EXPECTED IDENTIFIER");
        idName = tokenizer.idName();
        tokenizer.skipToken();
    }

    @Override
    public int execute() {
        if (input == null) throw new RuntimeException("ERROR: NO INPUT FILE AVAILABLE");

        if (!parser.identifiers().containsKey(idName)) parser.identifiers().put(idName, 0);

        if (input.hasNextLine()) {
            String currentLine = input.nextLine().trim();
            try {
                int value = Integer.parseInt(currentLine);
                parser.identifiers().put(idName, value);
            } catch (NumberFormatException e) {
                throw new RuntimeException("ERROR: EXPECTED INTEGER VALUE FOR " + idName + " BUT GOT " + currentLine, e);
            }
        } else throw new RuntimeException("ERROR: NO MORE LINES IN THE INPUT FILE");

        return 0;
    }

    @Override
    public void print(int indent) {

    }
}