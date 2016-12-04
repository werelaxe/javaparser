package lexer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Melon on 15.11.2016.
 */
public class Lexer {
    private HashMap<String, Grammar> langDict = new HashMap<>();
    public void register(String language, Grammar grammar) {
        langDict.put(language, grammar);
    }
    public ArrayList<Token> getLexems(String language, String program) {
        Grammar grammar = langDict.get(language);
        Parser parser = grammar.getParser();
        return parser.parse(program, grammar.getParserRules());
    }
    public String translate(String sourceLanguage, String finalLanguage, String source) {
        Lexer s = new Lexer();
        Grammar sourceGrammar = langDict.get(sourceLanguage);
        Grammar finalGrammar = langDict.get(finalLanguage);
        ArrayList<Token> lexems = sourceGrammar.getParser().parse(source, sourceGrammar.getParserRules());
        for(int i=0;i<lexems.size();i++)
        {
            Token t = lexems.get(i);
            //System.out.print("Token: " + t.toString());
            String type = t.getType();
            String subtype = t.getSubType();
            if (type.equals("other") || type.equals("whitespace"))
                System.out.print(t.getText());
            else {
                if (t.getText().equals(";") && lexems.get(i - 1).getText().equals("end"))
                    continue;
                for (Token kw : finalGrammar.getParser().getKeyWords()) {
                    if (kw.getSubType().equals(subtype)) {
                        System.out.print(kw.getText());
                        break;
                    }
                }
            }
        }
        return "";
    }
}
