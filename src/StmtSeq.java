public class StmtSeq implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private StmtSeq stmtSeq;
    private Stmt stmt;
    private boolean flag;

    public StmtSeq(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.flag = false;
    }

    @Override
    public void parse() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}