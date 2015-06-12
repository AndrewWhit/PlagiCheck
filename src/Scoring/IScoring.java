package Scoring;

import token.IToken;

/**
 * Created by Andrew on 08.06.2015.
 */
public interface IScoring {
    public double getScore (IToken orignalToken, IToken suspectToken);
    public double getGapScore ();
}
