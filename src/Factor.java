public class Factor implements ICore {
    private Tokenizer tokenizer;
    private Parser parser;
    private int value;
    private String idName;
    private Expr expr;
    private boolean isExpr, isInt, isId;

    public Factor(Tokenizer tokenizer, Parser parser) {
        this.tokenizer = tokenizer;
        this.parser = parser;
        this.isExpr = false;
        this.isInt = false;
        this.isId = false;
        this.value = 0;
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