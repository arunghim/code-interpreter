public class Factor implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private int value;
    private String idName;
    private Expr expr;
    private boolean isExpr, isInt, isId;

    public Factor(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.isExpr = false;
        this.isInt = false;
        this.isId = false;
        this.value = 0;
    }

    @Override
    public void parse() {
        int token = tokenizer.getToken();

        if (token == Types.LEFT_PAREN) {
            tokenizer.skipToken();
            isExpr = true;
            expr = new Expr(tokenizer, parser);
            expr.parse();

            if (tokenizer.getToken() != Types.RIGHT_PAREN)
                throw new RuntimeException("ERROR: EXPECTED RIGHT PARENTHESIS TOKEN");
            tokenizer.skipToken();

        } else if (token == Types.INT_CONST) {
            isInt = true;
            value = tokenizer.intVal();
            tokenizer.skipToken();

        } else if (token == Types.ID) {
            isId = true;
            idName = tokenizer.idName();
            tokenizer.skipToken();

        } else throw new RuntimeException("ERROR: EXPECTED INT, ID, OR PARENTHESIS");
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}