public class Expr implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Term term;
    private Expr expr;
    private int opToken;

    public Expr(Tokenizer tokenizer, Parser parser) {
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