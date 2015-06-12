package Presenter;

import Matrix.IAlignmentMatrix;
import lexer.ILexer;
import tokenSequences.ITokenSequence;

/**
 * Created by Andrew on 08.06.2015.
 */
public class Presenter implements IPresenter {
    IAlignmentMatrix matrix;
    ILexer lexer;
    ITokenSequence original;
    ITokenSequence suspect;

    public Presenter (IAlignmentMatrix matrix, ILexer lexer, ITokenSequence original, ITokenSequence suspect) {
        this.matrix = matrix;
        this.lexer = lexer;
        this.original = original;
        this.suspect = suspect;
    }
    @Override
    public String backward() {
        return null;
    }

    @Override
    public String threeColumnOutput() {
        return null;
    }
}
