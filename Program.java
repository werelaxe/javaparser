package lexer;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        String input;
        try {
            input = new Scanner(new File("src/lexer/in_pas.txt")).useDelimiter("\\A").next();
        } catch (FileNotFoundException e) {
            input = "begin\nend.";
        }
        Lexer lexer = new Lexer();
        lexer.register("pascal", new PascalGrammar());
        lexer.register("c", new CGrammar());
        lexer.translate("pascal", "c", input);
        //lexer.translate("c", "pascal", input);
    }
}

