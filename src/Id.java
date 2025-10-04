public class Id implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private String idName;

    public Id(Parser parser, Tokenizer tokenizer) {
        this.parser = parser;
        this.tokenizer = tokenizer;
    }

    @Override
    public void parse() {
        while (tokenizer.getToken() != Types.SEMICOLON) {
            int token = tokenizer.getToken();
            if (token == Types.ID) {
                idName = tokenizer.idName();
                if (!parser.identifiers().containsKey(idName)) parser.identifiers().put(idName, null);
                tokenizer.skipToken();
            } else if (token == Types.COMMA) tokenizer.skipToken();
            else throw new RuntimeException(
                        "ERROR: Unexpected token '" + token + "' in identifier list.");
        }
        tokenizer.skipToken();
    }

    @Override
    public int execute() {
        return 0;
    }

    @Override
    public void print(int indent) {

    }
}