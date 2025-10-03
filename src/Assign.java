public class Assign implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Expr expr;
    private String idName;

    public Assign(Tokenizer tokenizer, Parser parser) {
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