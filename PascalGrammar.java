package lexer;

/**
 * Created by Melon on 15.11.2016.
 */
public class PascalGrammar extends Grammar{
    public PascalGrammar() {
        super(new PascalParser(), new ParserRules("//", "{", "}", false));
    }
}
