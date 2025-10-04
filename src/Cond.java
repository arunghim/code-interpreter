public class Cond implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Comp comp;
    private Cond leftCond, rightCond;
    private int opToken;

    public Cond(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() == Types.LEFT_PAREN) {
            tokenizer.skipToken();

            if (tokenizer.getToken() == Types.EXCLAMATION) {
                tokenizer.skipToken();
                opToken = Types.EXCLAMATION;
                leftCond = new Cond(tokenizer, parser);
                leftCond.parse();
            } else {
                leftCond = new Cond(tokenizer, parser);
                leftCond.parse();

                if (tokenizer.getToken() == Types.AND || tokenizer.getToken() == Types.OR) {
                    opToken = tokenizer.getToken();
                    tokenizer.skipToken();
                    rightCond = new Cond(tokenizer, parser);
                    rightCond.parse();
                }
            }

            if (tokenizer.getToken() != Types.RIGHT_PAREN)
                throw new RuntimeException("ERROR: RIGHT PARENTHESIS TOKEN EXPECTED");
            tokenizer.skipToken();

        } else {
            comp = new Comp(tokenizer, parser);
            comp.parse();
        }
    }

    @Override
    public void execute() {

    }

    @Override
    public void print(int indent) {

    }
}