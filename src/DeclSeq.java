public class DeclSeq implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private DeclSeq deqSeq;
    private Decl decl;
    private Boolean hasDeclSeq, printCheck;

    public DeclSeq(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.hasDeclSeq = false;
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