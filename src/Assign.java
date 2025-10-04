public class Assign implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Expr expr;
    private String idName;

    public Assign(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() != Types.ID) throw new RuntimeException("ERROR: ID TOKEN EXPECTED");

        idName = tokenizer.idName();
        tokenizer.skipToken();

        if (tokenizer.getToken() != Types.ASSIGN) throw new RuntimeException("ERROR: ASSIGNMENT '=' TOKEN EXPECTED");
        tokenizer.skipToken();

        expr = new Expr(tokenizer, parser);
        expr.parse();

        if (tokenizer.getToken() != Types.SEMICOLON) throw new RuntimeException("ERROR: SEMICOLON ';' EXPECTED");
        tokenizer.skipToken();
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}