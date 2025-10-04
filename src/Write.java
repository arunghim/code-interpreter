import java.util.ArrayList;

public class Write implements ICore {
    private final Tokenizer tokenizer;
    private final Parser parser;
    private final ArrayList<String> idNames;

    public Write(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.idNames = new ArrayList<>();
    }

    @Override
    public void parse() {
        tokenizer.skipToken();
        if (tokenizer.getToken() != Types.ID) throw new IllegalArgumentException("ERROR: ID TOKEN EXPECTED");
        idNames.add(tokenizer.idName());
        tokenizer.skipToken();

        while (tokenizer.getToken() == Types.COMMA) {
            tokenizer.skipToken();
            if (tokenizer.getToken() != Types.ID) throw new IllegalArgumentException("ERROR: ID TOKEN EXPECTED");
            idNames.add(tokenizer.idName());
            tokenizer.skipToken();
        }

        if (tokenizer.getToken() != Types.SEMICOLON)
            throw new IllegalArgumentException("ERROR: SEMICOLON TOKEN EXPECTED");
        tokenizer.skipToken();
    }

    @Override
    public int execute() {
        for (String idName : idNames) {
            if (!parser.identifiers().containsKey(idName))
                throw new IllegalArgumentException("ERROR: UNDECLARED IDENTIFIER " + idName);
            else {
                Object value = parser.identifiers().get(idName);
                if (value == null) throw new IllegalStateException("ERROR: IDENTIFIER " + idName + " NOT INITIALIZED");
                System.out.println(idName + " = " + value);
            }
        }

        return 0;
    }

    @Override
    public void print(int indent) {

    }
}