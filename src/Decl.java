public class Decl implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private String idName;

    public Decl(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() == Types.ID) {
            idName = tokenizer.idName();
            if (!parser.identifiers().containsKey(idName)) {
                parser.identifiers().put(idName, null);
                tokenizer.skipToken();
            } else throw new RuntimeException("ERROR: ID '" + idName + "' ALREADY DECLARED.");

        } else if (tokenizer.getToken() != Types.SEMICOLON)
            throw new RuntimeException("ERROR: ID OR SEMICOLON TOKEN EXPECTED");
    }

    @Override
    public void execute() {
    }

    @Override
    public void print(int indent) {

    }
}