import java.util.ArrayList;
import java.util.List;

public class Decl implements ICore {
    private final Tokenizer tokenizer;
    private String idName;
    private final List<String> idNames = new ArrayList<>();

    public Decl(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void parse() {
        if (tokenizer.getToken() != Types.ID)
            throw new RuntimeException("ERROR: ID TOKEN EXPECTED AT START OF DECLARATION.");

        Id idManager = Id.getInstance(tokenizer);
        idName = tokenizer.idName();

        if (idManager.isDeclared(idName))
            throw new RuntimeException("ERROR: ID '" + idName + "' ALREADY DECLARED.");

        idManager.declare(idName);
        idNames.add(idName);

        tokenizer.skipToken();

        if (tokenizer.getToken() == Types.COMMA) {
            tokenizer.skipToken();
            while (tokenizer.getToken() == Types.ID) {
                idName = tokenizer.idName();

                if (idManager.isDeclared(idName))
                    throw new RuntimeException("ERROR: ID '" + idName + "' ALREADY DECLARED.");

                idManager.declare(idName);
                idNames.add(idName);

                tokenizer.skipToken();

                if (tokenizer.getToken() == Types.COMMA)
                    tokenizer.skipToken();
            }
        }

        if (tokenizer.getToken() != Types.SEMICOLON)
            throw new RuntimeException("ERROR: SEMICOLON ';' EXPECTED AFTER DECLARATION LIST.");

        tokenizer.skipToken();
    }

    @Override
    public int execute() {
        return 0;
    }

    @Override
    public void print(int indent) {
        String indentation = " ".repeat(indent);
        System.out.print(indentation);
        for (int i = 0; i < idNames.size(); i++) {
            System.out.print(idNames.get(i));
            if (i < idNames.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
