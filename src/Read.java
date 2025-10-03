import java.util.Scanner;

public class Read implements ICore {
    private static Scanner input;
    private Tokenizer tokenizer;
    private Parser parser;
    private String idName;

    public Read(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}