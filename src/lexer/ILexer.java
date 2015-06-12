package lexer;

import token.IToken;
import token.Token;

import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by Andrew on 27.03.2015.
 */
public interface ILexer {

    public IToken getNextToken() throws IOException;
    public String decode(IToken tk);
    public void setPushbackReader(PushbackReader pb);
    public String decodeAufgabe2(IToken tk);
}
