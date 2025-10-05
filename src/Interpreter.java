void main() {
    try (Scanner sc = new Scanner(System.in)) {
        String codePath = "/Users/arunghimire/Workspace/code-interpreter/data/programs/legal/mathUgly.txt";
        String dataPath = "/Users/arunghimire/Workspace/code-interpreter/data/programs/input/mathOpYgtX.txt";

        Parser parser = new Parser(codePath, dataPath);

        parser.parse();
        parser.execute();
        parser.print();
    }
}