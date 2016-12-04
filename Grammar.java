package lexer;

/**
 * Created by Melon on 15.11.2016.
 */
public class Grammar {
    public Grammar(Parser parser, ParserRules parserRules) {
        this.parserRules = parserRules;
        this.parser = parser;
    }
    private ParserRules parserRules;
    private Parser parser;
    private String lineCommentSymbol;
    private String startBlockSymbol;
    private String endBlockSymbol;
    private boolean caseSensitive;
    public boolean getCaseSensitive() {
        return caseSensitive;
    }
    public String getLineCommentSymbol() {
        return lineCommentSymbol;
    }
    public String getStartBlockSymbol() {
        return startBlockSymbol;
    }
    public String getEndBlockSymbol() {
        return endBlockSymbol;
    }
    public ParserRules getParserRules() {
        return parserRules;
    }
    public Parser getParser() {
        return parser;
    }
}
