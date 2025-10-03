public class Cond implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private Comp comp;
    private Cond leftCond, rightCond;
    private int opToken;

    public Cond(Tokenizer tokenizer, Parser parser) {
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