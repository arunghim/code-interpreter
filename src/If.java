public class If implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Cond cond;
    private StmtSeq ifSeq, elseSeq;
    private boolean hasAlt;

    public If(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        tokenizer.skipToken();
        cond = new Cond(tokenizer, parser);
        cond.parse();

        if (tokenizer.getToken() != Types.THEN) throw new RuntimeException("ERROR: THEN TOKEN EXPECTED");
        tokenizer.skipToken();

        ifSeq = new StmtSeq(tokenizer, parser);
        ifSeq.parse();

        if (tokenizer.getToken() == Types.ELSE) {
            tokenizer.skipToken();
            elseSeq = new StmtSeq(tokenizer, parser);
            elseSeq.parse();
            hasAlt = true;
        }

        if (tokenizer.getToken() != Types.END) throw new RuntimeException("ERROR: END-IF TOKEN EXPECTED");
        tokenizer.skipToken();

        if (tokenizer.getToken() != Types.SEMICOLON)
            throw new RuntimeException("ERROR: SEMICOLON AFTER END-IF EXPECTED");
        tokenizer.skipToken();
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}