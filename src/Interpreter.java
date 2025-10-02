void main() {
    try (Scanner sc = new Scanner(System.in)) {
        IO.print("Enter path to source file: ");
        String filePath = sc.nextLine();

        Tokenizer tokenizer = new Tokenizer(filePath);
        while (true) {
            int token = tokenizer.getToken();
            switch (token) {
                case 33 -> {
                    IO.println("Token: " + token);
                    IO.println("End of file reached.");
                    return;
                }
                case 34 -> {
                    IO.println("Token: " + token);
                    System.err.println("Error: Invalid token encountered.");
                    return;
                }
                case 32 -> {
                    IO.println("Token: " + token + " IdName: " + tokenizer.idName());
                    tokenizer.skipToken();
                }
                case 31 -> {
                    IO.println("Token: " + token + " Integer: " + tokenizer.intVal());
                    tokenizer.skipToken();
                }
                default -> {
                    IO.println("Token: " + token);
                    tokenizer.skipToken();
                }
            }
        }
    }
}
