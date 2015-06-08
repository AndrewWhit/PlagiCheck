package lexer;

import token.IToken;
import token.Token;

import java.io.IOException;

/**
 * Created by Andrew on 27.03.2015.
 */
public interface ILexer {

    public IToken getNextToken() throws IOException;
    public String decode(IToken tk);
}
