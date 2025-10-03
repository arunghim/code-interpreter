public class Stmt implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private If coreIf;
    private Assign coreAssign;
    private While coreWhile;
    private Write coreWrite;
    private ReadSeq coreReadSeq;
    private ICore stmt;

    public Stmt(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
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