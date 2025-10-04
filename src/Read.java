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
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}