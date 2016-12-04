package lexer;

/**
 * Created by Melon on 15.11.2016.
 */
public class ParserRules {
    public ParserRules(String lineCommentSymbol, String startBlockSymbol, String endBlockSymbol, boolean caseSensitive) {
        this.lineCommentSymbol = lineCommentSymbol;
        this.startBlockSymbol = startBlockSymbol;
        this.endBlockSymbol = endBlockSymbol;
        this.caseSensitive = caseSensitive;
    }

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
}
