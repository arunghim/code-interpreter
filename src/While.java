public class While implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Cond cond;
    private StmtSeq stmtSeq;

    public While(Tokenizer tokenizer, Parser parser) {
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