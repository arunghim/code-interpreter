public class DeclSeq implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private DeclSeq declSeq;
    private Decl decl;
    private boolean hasDeclSeq;

    public DeclSeq(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.hasDeclSeq = false;
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() == Types.INT) {
            tokenizer.skipToken();
        }

        decl = new Decl(tokenizer, parser);
        decl.parse();

        if (tokenizer.getToken() == Types.COMMA) {
            tokenizer.skipToken();
            hasDeclSeq = true;
            declSeq = new DeclSeq(tokenizer, parser);
            declSeq.parse();
        }

        if (tokenizer.getToken() == Types.SEMICOLON) {
            tokenizer.skipToken();
        }

        if (tokenizer.getToken() == Types.INT) {
            hasDeclSeq = true;
            declSeq = new DeclSeq(tokenizer, parser);
            declSeq.parse();
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}