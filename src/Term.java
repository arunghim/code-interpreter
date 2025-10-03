public class Term implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Factor factor;
    private Term term;
    private int opToken;

    public Term(Tokenizer tokenizer, Parser parser) {
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