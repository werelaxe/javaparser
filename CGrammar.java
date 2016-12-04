package lexer;

/**
 * Created by Melon on 15.11.2016.
 */
public class CGrammar extends Grammar {
    public CGrammar() {
        super(new CParser(), new ParserRules("//", "/*", "*/", false));
    }
}
