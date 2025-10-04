public class Comp implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Expr leftExpr, rightExpr;
    private int opToken;
    private boolean flag;

    public Comp(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        leftExpr = new Expr(tokenizer, parser);
        leftExpr.parse();

        if (tokenizer.getToken() == Types.EQUALS) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
        } else if (tokenizer.getToken() == Types.LESS) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
        } else if (tokenizer.getToken() == Types.GREATER) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
        } else if (tokenizer.getToken() == Types.LESS_EQUAL) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
        } else if (tokenizer.getToken() == Types.GREATER_EQUAL) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();
        } else throw new RuntimeException("ERROR: COMPARISON TOKEN EXPECTED");

        rightExpr = new Expr(tokenizer, parser);
        rightExpr.parse();
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}