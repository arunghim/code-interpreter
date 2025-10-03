import java.util.ArrayList;

public class Write implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private ArrayList<String> idNames;

    public Write(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.idNames = new ArrayList<>();
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