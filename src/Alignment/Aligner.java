package Alignment;

import Matrix.IAlignmentMatrix;
import Matrix.Matrix;
import Region.IRegion;
import Scoring.IScoring;
import token.IToken;
import tokenSequences.ITokenSequence;

/**
 * Created by Andrew on 08.06.2015.
 */
public class Aligner implements IAligner{
    ITokenSequence original;
    ITokenSequence suspect;
    IScoring scoring;
    IRegion region;
    public Aligner (ITokenSequence original, ITokenSequence suspect, IScoring scoring, IRegion region) {
        this.original = original;
        this.suspect = suspect;
        this.scoring = scoring;
        this.region = region;
    }

    @Override
    public IAlignmentMatrix forward() {
        return new Matrix();
    }
}
