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
            if (tokenizer.getToken() == Types.ID) {
                idName = tokenizer.idName();
                parser.identifiers().put(idName, null);
                tokenizer.skipToken();
            } else if (tokenizer.getToken() == Types.COMMA) tokenizer.skipToken();
            else throw new RuntimeException(
                        "ERROR: Unexpected token '" + tokenizer.getToken() + "' in identifier list.");
        }
        tokenizer.skipToken();
    }

    @Override
    public int execute() {
        return parser.identifiers().get(idName);
    }

    @Override
    public void print(int indent) {
        System.out.print(idName);
    }
}