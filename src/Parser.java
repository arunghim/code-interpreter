import java.util.HashMap;

public class Parser {
    private static final HashMap<String, Integer> identifiers = new HashMap<>();
    private final Tokenizer tokenizer;
    private final String data;
    private Prog prog;

    public Parser(String program, String data) {
        this.tokenizer = new Tokenizer(program);
        this.data = data;
        build();
    }

    private void build() {
        if (tokenizer.getToken() != Types.PROGRAM) throw new RuntimeException("ERROR: PROGRAM TOKEN EXPECTED");
        prog = new Prog(tokenizer, this);
    }

    public HashMap<String, Integer> identifiers() {
        return identifiers;
    }

    public String data() {
        return data;
    }

    public void parse() {
        prog.parse();
    }

    public void print() {
        prog.print(0);
    }

    public void execute() {
        prog.execute();
    }
}