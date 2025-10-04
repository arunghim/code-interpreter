public class Comp implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Expr leftExpr, rightExpr;
    private int opToken;

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
    public int execute() {
        boolean flag;

        if (opToken == Types.EQUALS) flag = leftExpr.execute() == rightExpr.execute();
        else if (opToken == Types.LESS) flag = leftExpr.execute() < rightExpr.execute();
        else if (opToken == Types.GREATER) flag = leftExpr.execute() > rightExpr.execute();
        else if (opToken == Types.LESS_EQUAL) flag = leftExpr.execute() <= rightExpr.execute();
        else if (opToken == Types.GREATER_EQUAL) flag = leftExpr.execute() >= rightExpr.execute();
        else throw new RuntimeException("ERROR: COMPARISON TOKEN EXPECTED");

        return flag ? 1 : 0;
    }

    @Override
    public void print(int indent) {

    }
}