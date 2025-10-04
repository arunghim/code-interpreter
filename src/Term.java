public class Term implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private Factor factor;
    private Term term;
    private int opToken;

    public Term(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        factor = new Factor(tokenizer, parser);
        factor.parse();

        if (tokenizer.getToken() == Types.MULT) {
            opToken = tokenizer.getToken();
            tokenizer.skipToken();

            term = new Term(tokenizer, parser);
            term.parse();
        }
    }

    @Override
    public int execute() {
        int value = factor.execute();
        if (opToken == Types.MULT && term != null) value *= term.execute();
        return value;
    }

    @Override
    public void print(int indent) {

    }
}