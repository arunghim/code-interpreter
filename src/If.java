public class If implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Cond cond;
    private StmtSeq ifSeq, elseSeq;
    private boolean hasAlt;

    public If(Tokenizer tokenizer, Parser parser) {
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