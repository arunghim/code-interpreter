public class Decl implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private String idName;

    public Decl(Tokenizer tokenizer, Parser parser) {
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