package lexer;

import java.util.ArrayList;

/**
 * Created by melon on 04.12.16.
 */
public class MathGrammar extends Grammar {
    public MathGrammar() {
        super(new MathParser(), null);
        ParserRules parserRules = new ParserRules("//", "/*", "*/", false);
        parserRules.endNumberSymbol = new ArrayList<>();
        parserRules.endNumberSymbol.add('i');
        this.parserRules = parserRules;
    }
}
