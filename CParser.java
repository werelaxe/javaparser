package lexer;

public class CParser extends Parser {
    public CParser() {
        super();
        addKeyWord(new Token("+", "operator", "add"));
        addKeyWord(new Token("-", "operator", "subtract"));
        addKeyWord(new Token("*", "operator", "multiply"));
        addKeyWord(new Token("/", "operator", "int_div"));
        addKeyWord(new Token("(", "operator", "left_parenthesis"));
        addKeyWord(new Token(")", "operator", "right_parenthesis"));
        addKeyWord(new Token("[", "operator", "left_sq_bracket"));
        addKeyWord(new Token("]", "operator", "right_sq_bracket"));
        addKeyWord(new Token("==", "operator", "equals"));
        addKeyWord(new Token("=", "operator", "assigned"));
        addKeyWord(new Token(":", "operator", "colon"));
        addKeyWord(new Token(";", "operator", "semicolon"));
        addKeyWord(new Token("<", "operator", "lesser"));
        addKeyWord(new Token(">", "operator", "greater"));
        addKeyWord(new Token("<=", "operator", "leq"));
        addKeyWord(new Token(">=", "operator", "geq"));
        addKeyWord(new Token(",", "operator", "comma"));
        addKeyWord(new Token(".", "operator", "dot"));
        addKeyWord(new Token("{", "operator", "begin"));
        addKeyWord(new Token("}", "operator", "end"));
        addKeyWord(new Token("void", "keyword", "procedure"));
        addKeyWord(new Token("while", "keyword", "cycle_while"));
        addKeyWord(new Token("}while", "keyword", "until"));
        addKeyWord(new Token("do{", "keyword", "repeat"));
        addKeyWord(new Token("for", "keyword", "cycle_for"));
        addKeyWord(new Token("if", "keyword", "condition"));
        addKeyWord(new Token("float", "type", "float"));
        addKeyWord(new Token("String", "type", "string"));
        addKeyWord(new Token("int", "type", "int"));
        addKeyWord(new Token("boolean", "type", "bool"));
        addKeyWord(new Token("long", "type", "long"));
    }
}
