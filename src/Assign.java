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
    public int execute() {
        int value = expr.execute();

        if (parser.identifiers().containsKey(idName)) parser.identifiers().put(idName, value);
        else throw new RuntimeException("ERROR: ID " + idName + " NOT DECLARED");

        return 0;
    }

    @Override
    public void print(int indent) {
        String indentation = " ".repeat(indent);
        System.out.print(indentation + idName + " = ");
        expr.print(0);
        System.out.println(";");
    }
}