package lexer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class Parser {
    public Parser() {
        keyWords = new ArrayList<>();
    }

    private ArrayList<Token> keyWords;

    public void addKeyWord(Token newKeyWord) {
        keyWords.add(newKeyWord);
    }

    private static CharType getCharType(char ch) {
        if (Character.isWhitespace(ch))
            return CharType.WHITESPACE;
        if (Character.isAlphabetic(ch) || Character.isDigit(ch))
            return CharType.ALPHABETIC;
        return CharType.OTHER;
    }

    public ArrayList<Token> getKeyWords() {
        return keyWords;
    }

    private static Comparator<Token> compByLen() {
        return new Comparator<Token>() {
            @Override
            public int compare(Token s1, Token s2) {
                return new Integer(s2.getText().length()).compareTo(s1.getText().length());
            }
        };
    }

    public ArrayList<Token> getKeyWords(int len, String type) {
        ArrayList<Token> newKeyWords = new ArrayList<>();
        for (int i = 0; i < keyWords.size(); i++)
            if (keyWords.get(i).getText().length() <= len && keyWords.get(i).getType() == type)
                newKeyWords.add(keyWords.get(i));
        Collections.sort(newKeyWords, compByLen());
        return newKeyWords;
    }

    private ArrayList<Token> parseOperators(String operators) {
        StringBuilder buffer = new StringBuilder(operators);
        ArrayList<Token> tokens = new ArrayList<Token>();
        boolean found;
        while (buffer.length() != 0) {
            found = false;
            ArrayList<Token> ops = getKeyWords(operators.length(), "operator");
            for (int i = 0; i < ops.size(); i++) {
                if (buffer.toString().startsWith(ops.get(i).getText())) {
                    tokens.add(ops.get(i));
                    buffer = new StringBuilder(buffer.substring(ops.get(i).getText().length()));
                    found = true;
                    break;
                }
            }
            if (!found) {
                tokens.add(new Token(buffer.toString(), "unparsable_operator"));
                break;
            }

        }
        return tokens;
    }

    private Token getToken(String text) {
        ArrayList<Token> tokens = getKeyWords();
        for (Token t : tokens) {
            if (t.getText().equals(text)) {
                return t;
            }
        }
        return new Token(text, "other");
    }

    private static String fixCommentSymbol(String symb) {
        try {
            Pattern.compile(symb);
        } catch (PatternSyntaxException e) {
            symb = "\\" + symb;
        }
        return symb;
    }
    private static String removeBlockComments(String source, String startSymb, String endSymb) {
        return source.replaceAll(fixCommentSymbol(startSymb)+ "[\\d\\D]*" + fixCommentSymbol(endSymb), "");
    }

    private static String removeLineComments(String source, String commentSymbol) {
        return source.replaceAll(commentSymbol + ".*", "");
    }

    public ArrayList<Token> parse(String text, ParserRules parserRules) {
        if (!parserRules.getCaseSensitive())
            text = text.toLowerCase();
        return parseTokens(removeLineComments(removeBlockComments(text,
                parserRules.getStartBlockSymbol(),
                parserRules.getEndBlockSymbol()),
                parserRules.getLineCommentSymbol()));
    }

    private ArrayList<Token> parseTokens(String text) {
        ArrayList<Token> lexems = new ArrayList<>();
        //Character.isAlphabetic()
        //Character.isWhitespace()
        char prevChar = text.charAt(0);
        int prevPosition = 0;
        int i = 0;
        while (i < text.length()) {
            if (getCharType(text.charAt(i)) != getCharType(prevChar)) {
                String newToken = text.substring(prevPosition, i);
                if (getCharType(prevChar) == CharType.OTHER) {
                    ArrayList<Token> opTokens = parseOperators(newToken);
                    for (int j = 0; j < opTokens.size(); j++)
                        lexems.add(opTokens.get(j));
                } else if (getCharType(prevChar) == CharType.WHITESPACE)
                    lexems.add(new Token(newToken, "whitespace"));
                else {
                    lexems.add(getToken(newToken));
                }
                prevChar = text.charAt(i);
                prevPosition = i;
            }
            i++;
        }
        return lexems;
    }
}