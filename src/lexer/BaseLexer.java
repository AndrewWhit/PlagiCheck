package lexer;

import token.Token;

import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by Andrew on 08.05.2015.
 */
public class BaseLexer implements ILexer {
    PushbackReader pushbackReader;
    public BaseLexer (PushbackReader pushbackReader) {
        this.pushbackReader = pushbackReader;
    }

    @Override
    public Token getNextToken() throws IOException {
        return null;
    }

    @Override
    public String decode(Token tk) {
        return null;
    }
}
