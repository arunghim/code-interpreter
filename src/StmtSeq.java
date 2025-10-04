public class StmtSeq implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private StmtSeq stmtSeq;
    private Stmt stmt;
    private boolean flag;

    public StmtSeq(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        flag = false;
    }

    @Override
    public void parse() {
        stmt = new Stmt(tokenizer, parser);
        stmt.parse();
        int token = tokenizer.getToken();
        if (token != Types.END && token != Types.ELSE && token != Types.LOOP) {
            stmtSeq = new StmtSeq(tokenizer, parser);
            stmtSeq.parse();
            flag = true;
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}