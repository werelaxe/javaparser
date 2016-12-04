package lexer;

public class PascalParser extends Parser {
    public PascalParser() {
        super();
        addKeyWord(new Token("+", "operator", "add"));
        addKeyWord(new Token("-", "operator", "subtract"));
        addKeyWord(new Token("*", "operator", "multiply"));
        addKeyWord(new Token("/", "operator", "divide"));
        addKeyWord(new Token("(", "operator", "left_parenthesis"));
        addKeyWord(new Token(")", "operator", "right_parenthesis"));
        addKeyWord(new Token("[", "operator", "left_sq_bracket"));
        addKeyWord(new Token("]", "operator", "right_sq_bracket"));
        addKeyWord(new Token("=", "operator", "equals"));
        addKeyWord(new Token(":=", "operator", "assigned"));
        addKeyWord(new Token(":", "operator", "colon"));
        addKeyWord(new Token(";", "operator", "semicolon"));
        addKeyWord(new Token("<", "operator", "lesser"));
        addKeyWord(new Token(">", "operator", "greater"));
        addKeyWord(new Token("<=", "operator", "leq"));
        addKeyWord(new Token(">=", "operator", "geq"));
        addKeyWord(new Token(",", "operator", "comma"));
        addKeyWord(new Token(".", "operator", "dot"));
        addKeyWord(new Token("div", "keyword", "int_div"));
        addKeyWord(new Token("begin", "keyword", "begin"));
        addKeyWord(new Token("end", "keyword", "end"));
        addKeyWord(new Token("procedure", "keyword", "procedure"));
        addKeyWord(new Token("function", "keyword", "function"));
        addKeyWord(new Token("repeat", "keyword", "repeat"));
        addKeyWord(new Token("while", "keyword", "cycle_while"));
        addKeyWord(new Token("do", "keyword", "execution"));
        addKeyWord(new Token("for", "keyword", "cycle_for"));
        addKeyWord(new Token("until", "keyword", "until"));
        addKeyWord(new Token("then", "keyword", "consequence"));
        addKeyWord(new Token("if", "keyword", "condition"));
        addKeyWord(new Token("var", "keyword", "declaration"));
        addKeyWord(new Token("real", "type", "float"));
        addKeyWord(new Token("string", "type", "string"));
        addKeyWord(new Token("integer", "type", "int"));
        addKeyWord(new Token("boolean", "type", "bool"));
        addKeyWord(new Token("longint", "type", "long"));
        addKeyWord(new Token("repeat", "keyword", "repeat"));
        addKeyWord(new Token("until", "keyword", "until"));
    }
}
