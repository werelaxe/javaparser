package lexer;


public class Token {
    private final String text;
    private final String type;
    private final String subtype;

    public Token(String text, String type) {
        this.type = type;
        this.text = text;
        this.subtype = "none";
    }
    public Token(String text, String type, String subtype) {
        this.type = type;
        this.text = text;
        this.subtype = subtype;
    }
    public String getType() {
        return type;
    }

    public String getSubType() {
        return subtype;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        if (type == "whitespace")
            return type + "(" + subtype + ")" + "[" + normalizeWSString(text) + "]";
        return type + "(" + subtype + ")" + "[" + text + "]";
    }

    public static String normalizeWSString(String text) {
        StringBuilder buffer = new StringBuilder();
        for(int i=0;i<text.length();i++) {
            if (text.charAt(i) == '\n')
                buffer.append("<new_line>");
            if (text.charAt(i) == '\t')
                buffer.append("<tabulation>");
            if (text.charAt(i) == ' ')
                buffer.append("<space>");
        }
        return buffer.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Token))
            throw new IllegalArgumentException();
        Token other = (Token) obj;
        return type.equals(other.type) && text.equals(other.text);
    }
}
