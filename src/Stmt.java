public class Stmt implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private ICore stmt;

    public Stmt(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        int token = tokenizer.getToken();

        if (token == Types.IF) {
            If coreIf = new If(tokenizer, parser);
            coreIf.parse();
            stmt = coreIf;
        } else if (token == Types.WHILE) {
            While coreWhile = new While(tokenizer, parser);
            coreWhile.parse();
            stmt = coreWhile;
        } else if (token == Types.READ) {
            ReadSeq coreReadSeq = new ReadSeq(tokenizer, parser);
            coreReadSeq.parse();
            stmt = coreReadSeq;
        } else if (token == Types.WRITE) {
            Write coreWrite = new Write(tokenizer, parser);
            coreWrite.parse();
            stmt = coreWrite;
        } else if (token == Types.ID) {
            Assign coreAssign = new Assign(tokenizer, parser);
            coreAssign.parse();
            stmt = coreAssign;
        } else {
            if (tokenizer.getToken() == Types.EOF || tokenizer.getToken() == Types.ELSE) return;
            else throw new RuntimeException("ERROR: INVALID STATEMENT TOKEN");
        }
    }

    @Override
    public int execute() {
        stmt.execute();
        return 0;
    }

    @Override
    public void print(int indent) {

    }
}