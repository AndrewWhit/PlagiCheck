package tokenSequences;

import token.IToken;

/**
 * Created by Andrew on 08.06.2015.
 */
public interface ITokenSequence {
    public void add (IToken tk);
    public IToken getToken (int index);
    public int length ();
}
