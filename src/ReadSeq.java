public class ReadSeq implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Read read;
    private ReadSeq readSeq;
    private boolean hasReadSeq;

    public ReadSeq(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.hasReadSeq = false;
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