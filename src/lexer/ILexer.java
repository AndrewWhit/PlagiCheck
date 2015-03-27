package lexer;

import java.io.IOException;

/**
 * Created by Andrew on 27.03.2015.
 */
public interface ILexer {
    IToken  getNextToken() throws IOException;
    String decode(IToken tk);
}
