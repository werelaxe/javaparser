package lexer;

/**
 * Created by melon on 04.12.16.
 */
public class MathGrammar extends Grammar {
    public MathGrammar() {
        super(new MathParser(), new ParserRules("//", "/*", "*/", false));
    }
}
