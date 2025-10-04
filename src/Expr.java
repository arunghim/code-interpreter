public class Expr implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Term term;
    private Expr expr;
    private int opToken;

    public Expr(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        term = new Term(tokenizer, parser);
        term.parse();

        if (tokenizer.getToken() == Types.PLUS || tokenizer.getToken() == Types.MINUS) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
            expr = new Expr(tokenizer, parser);
            expr.parse();
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}