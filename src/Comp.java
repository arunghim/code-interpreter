public class Comp implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Expr leftExpr, rightExpr;
    private int opToken;
    private boolean flag;

    public Comp(Tokenizer tokenizer, Parser parser) {
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