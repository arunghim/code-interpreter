public class While implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Cond cond;
    private StmtSeq stmtSeq;

    public While(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        tokenizer.skipToken();
        cond = new Cond(tokenizer, parser);
        cond.parse();

        if (tokenizer.getToken() != Types.LOOP) throw new RuntimeException("ERROR: LOOP TOKEN EXPECTED");
        tokenizer.skipToken();

        stmtSeq = new StmtSeq(tokenizer, parser);
        stmtSeq.parse();

        if (tokenizer.getToken() != Types.END) throw new RuntimeException("ERROR: END TOKEN EXPECTED");
        tokenizer.skipToken();

        if (tokenizer.getToken() != Types.SEMICOLON) throw new RuntimeException("ERROR: SEMICOLON TOKEN EXPECTED");
        tokenizer.skipToken();
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}