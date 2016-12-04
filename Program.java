package lexer;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        String input;
        try {
            input = new Scanner(new File("src/lexer/in_math.txt")).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            input = "2 + 2 * 2";
        }
        Lexer lexer = new Lexer();
        lexer.register("math", new MathGrammar());
        ArrayList<Token> lexems = lexer.getLexems("math", input);
        System.out.println(input);
        for (Token lexeme: lexems) {
            if (lexeme.getType() != "whitespace")
                System.out.println(lexeme);
        }
    }
}

