package tokenSequences;

import token.IToken;

import java.util.ArrayList;

/**
 * Created by Andrew on 08.06.2015.
 */
public class TokenSequence implements ITokenSequence {
    ArrayList<IToken> tokenList = new ArrayList<IToken>();
    @Override
    public void add(IToken tk) {
        tokenList.add(tk);
    }

    @Override
    public IToken getToken(int index) {
        return tokenList.get(index);
    }

    @Override
    public int length() {
        return tokenList.size();
    }
}
