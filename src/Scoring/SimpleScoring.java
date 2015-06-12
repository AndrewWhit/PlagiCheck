package Scoring;

import lexer.ILexer;
import token.IToken;

/**
 * Created by Andrew on 08.06.2015.
 */
public class SimpleScoring implements IScoring {
    ILexer lexer;
    IToken originalToken;
    IToken suspectToken;
    public SimpleScoring (ILexer lexer) {
        this.lexer = lexer;
    }
    @Override
    public double getScore(IToken orignalToken, IToken suspectToken) {
        if (isPerfect(originalToken, suspectToken)) {
            return 1;
        }
        return 0;
    }

    private boolean isPerfect (IToken originalToken, IToken suspectToken) {
        if (originalToken.getClassCode() == suspectToken.getClassCode() && originalToken.getRelativeCode() == suspectToken.getRelativeCode()) {
            return true;
        }
        return false;
    }

    private boolean noMatch (IToken originalToken, IToken suspectToken) {
        return true;
    }

    @Override
    public double getGapScore() {
        return 0;
    }
}
