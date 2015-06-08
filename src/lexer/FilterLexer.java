package lexer;

import token.IToken;
import token.Token;

import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by Andrew on 23.05.2015.
 */
public class FilterLexer implements ILexer {
    PushbackReader pushbackReader;
    ILexer lexer;

    public FilterLexer(PushbackReader pb) {
        lexer = new BaseLexer(pb);
    }

    @Override
    public IToken getNextToken() throws IOException {
        IToken token = lexer.getNextToken();
        if (token.getClassCode() == 15) {
            return lexer.getNextToken();
        }
        return token;
    }

    @Override
    public String decode(IToken tk) {
        return lexer.decode(tk);
    }

    /**
     * Filter whitespaces from the text.
     * @param pushbackReader
     * @return
     */
    private PushbackReader filter(PushbackReader pushbackReader) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            i = pushbackReader.read();
            while (i != -1) {
                char character = (char) i;
                if (!Character.isWhitespace(character)) {
                    stringBuffer.append(character);
                }
                i = pushbackReader.read();
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        try {
            pushbackReader.unread(stringBuffer.toString().toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pushbackReader;
    }
}

